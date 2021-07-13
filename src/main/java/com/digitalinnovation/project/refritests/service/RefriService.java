package com.digitalinnovation.project.refritests.service;

import com.digitalinnovation.project.refritests.dto.mapper.RefriMapper;
import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.entities.Refrigerante;
import com.digitalinnovation.project.refritests.exceptions.RefriAlreadyRegistredException;
import com.digitalinnovation.project.refritests.exceptions.RefriNotFoundException;
import com.digitalinnovation.project.refritests.repository.RefriRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RefriService {

    private final RefriRepository refriRepository;
    private final RefriMapper refriMapper = RefriMapper.INSTANCE;

    public List<RefrigeranteDTO> listAll() {
        return refriRepository.findAll()
                .stream()
                .map(refriMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RefrigeranteDTO findByName(String name) throws RefriNotFoundException {
        Refrigerante foundRefrigerante = refriRepository.findByName(name)
                .orElseThrow( () -> new RefriNotFoundException(name));

        return refriMapper.toDTO(foundRefrigerante);
    }

    public RefrigeranteDTO createRefri(RefrigeranteDTO refriDTO) throws RefriAlreadyRegistredException {
            verifyIfExistsAlreadyName(refriDTO.getName());
            Refrigerante refriConverter = refriMapper.toModel(refriDTO);
            Refrigerante refriCreated = refriRepository.save(refriConverter);
            return refriMapper.toDTO(refriCreated);
    }

    public void deleteById(Long id) throws RefriNotFoundException {
        verifyIfExistsId(id);
        refriRepository.deleteById(id);
    }

    private void verifyIfExistsId(Long id) throws RefriNotFoundException {
        refriRepository.findById(id).orElseThrow( () -> new RefriNotFoundException(id));
    }

    private void verifyIfExistsAlreadyName(String name) throws RefriAlreadyRegistredException {
        Optional<Refrigerante> optRefri = refriRepository.findByName(name);
        if(optRefri.isPresent()){
            throw new RefriAlreadyRegistredException(name);
        }
    }


}
