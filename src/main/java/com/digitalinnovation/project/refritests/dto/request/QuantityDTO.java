package com.digitalinnovation.project.refritests.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDTO {

    @NotEmpty
    @Max(100)
    private Integer quantidade;
}
