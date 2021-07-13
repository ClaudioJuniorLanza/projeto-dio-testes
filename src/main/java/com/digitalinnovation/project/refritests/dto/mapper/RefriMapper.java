package com.digitalinnovation.project.refritests.dto.mapper;

import com.digitalinnovation.project.refritests.dto.request.RefrigeranteDTO;
import com.digitalinnovation.project.refritests.entities.Refrigerante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface RefriMapper {

    RefriMapper INSTANCE = Mappers.getMapper(RefriMapper.class);

    Refrigerante toModel(RefrigeranteDTO dto);

    RefrigeranteDTO toDTO(Refrigerante dto);
}
