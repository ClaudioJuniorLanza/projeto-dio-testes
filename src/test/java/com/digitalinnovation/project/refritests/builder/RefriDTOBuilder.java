package com.digitalinnovation.project.refritests.builder;

import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.enums.RefriSabores;
import lombok.Builder;

@Builder
public class RefriDTOBuilder {

    @Builder.Default
    private Long id = 1L;
    @Builder.Default
    private String name = "Sukita";
    @Builder.Default
    private String marca = "Grupo Antartica";
    @Builder.Default
    private int max = 50;
    @Builder.Default
    private int quantidade = 10;
    @Builder.Default
    private RefriSabores type = RefriSabores.LARANJA;

    public RefrigeranteDTO toRefriDTO(){
        return new RefrigeranteDTO(
                id,
                name,
                marca,
                max,
                quantidade,
                type);
    }

}
