package com.digitalinnovation.project.refritests.service;

import com.digitalinnovation.project.refritests.builder.RefriDTOBuilder;
import com.digitalinnovation.project.refritests.dto.mapper.RefriMapper;
import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.entities.Refrigerante;
import com.digitalinnovation.project.refritests.exceptions.RefriNotFoundException;
import com.digitalinnovation.project.refritests.repository.RefriRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class RefriServiceTest {

    private static final long INVALID_REFRI_ID = 1L;

    @Mock
    private RefriRepository refriRepository;

    private RefriMapper refriMapper = RefriMapper.INSTANCE;

    @InjectMocks
    private RefriService refriService;

    @Test
    void quandoUmNomeForValidoRetornarORefri() throws RefriNotFoundException {

        //given
        RefrigeranteDTO expectedFoundRefrigeranteDTO = RefriDTOBuilder.builder().build().toRefriDTO();
        Refrigerante expectedFoundRefrigerante = refriMapper.toModel(expectedFoundRefrigeranteDTO);

        //when
        Mockito.when( refriRepository.findByName(expectedFoundRefrigerante.getName())).thenReturn(Optional.of(expectedFoundRefrigerante));

        //then
        RefrigeranteDTO foundRefrigeranteDTO = refriService.findByName(expectedFoundRefrigeranteDTO.getName());

        assertThat(foundRefrigeranteDTO, is(equalTo(expectedFoundRefrigeranteDTO)));

    }
}
