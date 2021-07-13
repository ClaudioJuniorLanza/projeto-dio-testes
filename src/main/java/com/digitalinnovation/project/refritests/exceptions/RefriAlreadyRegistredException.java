package com.digitalinnovation.project.refritests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefriAlreadyRegistredException extends Exception {

    public RefriAlreadyRegistredException(String refriName){
        super(String.format("Refri com o nome %s já existe no sistema", refriName));
    }
}
