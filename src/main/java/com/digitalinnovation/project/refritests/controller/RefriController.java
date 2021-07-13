package com.digitalinnovation.project.refritests.controller;

import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.exceptions.RefriAlreadyRegistredException;
import com.digitalinnovation.project.refritests.exceptions.RefriNotFoundException;
import com.digitalinnovation.project.refritests.service.RefriService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/refri")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RefriController {

    private final RefriService refriService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RefrigeranteDTO> listAll(){
        return refriService.listAll();
    }

    @GetMapping("/{name}")
    public RefrigeranteDTO getRefriByName(@PathVariable String name) throws RefriNotFoundException {
        return refriService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RefrigeranteDTO postRefri( @RequestBody RefrigeranteDTO refriDTO) throws RefriAlreadyRegistredException {
        return refriService.createRefri(refriDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws RefriNotFoundException {
         refriService.deleteById(id);
    }
}
