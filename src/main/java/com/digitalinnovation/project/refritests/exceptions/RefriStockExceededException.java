package com.digitalinnovation.project.refritests.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefriStockExceededException extends Exception{

    public RefriStockExceededException(Long id, int quantidadeParaIncremento){
        super(String.format("Refri com %s ID informadopara incremento excedeu a capacidade maxima do estoque: %s", id,quantidadeParaIncremento));
    }

}
