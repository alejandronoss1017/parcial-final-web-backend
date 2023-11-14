package com.canc.finalweb.dtos.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.canc.finalweb.dtos.CANCBookDto;
import com.canc.finalweb.models.CANCBook;

@Mapper
public interface CANCBookMapper {

    CANCBookMapper INSTANCE = Mappers.getMapper(CANCBookMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "library", target = "library")
    CANCBookDto bookToDto(CANCBook book);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "library", target = "library")
    @Mapping(target = "id", ignore = true)
    CANCBook dtoToBook(CANCBookDto dto);
}
