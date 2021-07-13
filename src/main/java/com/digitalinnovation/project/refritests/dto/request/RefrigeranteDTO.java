package com.digitalinnovation.project.refritests.dto.request;

import com.digitalinnovation.project.refritests.enums.RefriSabores;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefrigeranteDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String marca;

    @NotNull
    @Max(500)
    private Integer max;

    @NotEmpty
    @Max(100)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @NotNull
    private RefriSabores type;

}
