package com.digitalinnovation.project.refritests.service;

import com.digitalinnovation.project.refritests.builder.RefriDTOBuilder;
import com.digitalinnovation.project.refritests.dto.mapper.RefriMapper;
import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.entities.Refrigerante;
import com.digitalinnovation.project.refritests.exceptions.RefriAlreadyRegistredException;
import com.digitalinnovation.project.refritests.exceptions.RefriNotFoundException;
import com.digitalinnovation.project.refritests.repository.RefriRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RefriServiceTest {

    private static final long INVALID_REFRI_ID = 1L;

    @Mock
    private RefriRepository refriRepository;

    private RefriMapper refriMapper = RefriMapper.INSTANCE;

    @InjectMocks
    private RefriService refriService;

    @Test
    void quandoInformadoUmRefriJaExistenteExibirUmaException(){
        //given
        RefrigeranteDTO expectedRefrigeranteDTO = RefriDTOBuilder.builder().build().toRefriDTO();
        Refrigerante duplicatedRefri = refriMapper.toModel(expectedRefrigeranteDTO);

        //when
        when(refriRepository.findByName(expectedRefrigeranteDTO.getName())).thenReturn(Optional.of(duplicatedRefri));

        //then
        assertThrows(RefriAlreadyRegistredException.class, () -> refriService.createRefri(expectedRefrigeranteDTO));
    }

    @Test
    void quandoUmNomeForValidoRetornarORefri() throws RefriNotFoundException {

        //given
        RefrigeranteDTO expectedFoundRefrigeranteDTO = RefriDTOBuilder.builder().build().toRefriDTO();
        Refrigerante expectedFoundRefrigerante = refriMapper.toModel(expectedFoundRefrigeranteDTO);

        //when
        when( refriRepository.findByName(expectedFoundRefrigerante.getName())).thenReturn(Optional.of(expectedFoundRefrigerante));

        //then
        RefrigeranteDTO foundRefrigeranteDTO = refriService.findByName(expectedFoundRefrigeranteDTO.getName());

        assertThat(foundRefrigeranteDTO, is(equalTo(expectedFoundRefrigeranteDTO)));

    }

    @Test
    void quandoNaoExistirUmRefriExibirUmaException(){
        //given
        RefrigeranteDTO expectedRefrigeranteDTO = RefriDTOBuilder.builder().build().toRefriDTO();

        //when
        when(refriRepository.findByName(expectedRefrigeranteDTO.getName())).thenReturn(Optional.empty());

        //then
        assertThrows(RefriNotFoundException.class, () -> refriService.findByName(expectedRefrigeranteDTO.getName()) );
    }

    @Test
    void quandoChamadaUmaListaRefriRetornarUmaListaDeRefri(){

        //given
        RefrigeranteDTO expectedFoundRefrigeranteDTO = RefriDTOBuilder.builder().build().toRefriDTO();
        Refrigerante expectedFoundRefrigerante = refriMapper.toModel(expectedFoundRefrigeranteDTO);

        //when
        when(refriRepository.findAll()).thenReturn(Collections.singletonList(expectedFoundRefrigerante));

        //then
        List<RefrigeranteDTO> foundListRefrigeranteDTO = refriService.listAll();

        assertThat(foundListRefrigeranteDTO, is(not(empty())));
        assertThat(foundListRefrigeranteDTO.get(0), is(equalTo(expectedFoundRefrigeranteDTO)));
    }

    @Test
    void quandoUmaListadeRefriForChamadaRetornaUmaListaVaziaDeRefri(){
        //when
        when(refriRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //then
        List<RefrigeranteDTO> foundListRefrigeranteDTO = refriService.listAll();

        assertThat(foundListRefrigeranteDTO, is(empty()));
    }

}
