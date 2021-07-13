package com.digitalinnovation.project.refritests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RefriNotFoundException extends Exception {

    public RefriNotFoundException(Long id){
        super(String.format("Refri com o id %s não encontrado no sistema", id));
    }

    public RefriNotFoundException(String refriName){
        super(String.format("Refri com o nome %s não encontrado no sistema", refriName));
    }

}
