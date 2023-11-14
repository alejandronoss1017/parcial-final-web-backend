package com.canc.finalweb.dtos.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.canc.finalweb.dtos.CANCLibraryDto;
import com.canc.finalweb.models.CANCLibrary;

@Mapper
public interface CANCLibraryMapper {

    CANCLibraryMapper INSTANCE = Mappers.getMapper(CANCLibraryMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    CANCLibraryDto libraryToDto(CANCLibrary library);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "city", target = "city")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    CANCLibrary dtoToLibrary(CANCLibraryDto dto);

}
