package com.canc.finalweb.dtos;

import com.canc.finalweb.models.CANCLibrary;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CANCBookDto {

    private String name;

    private CANCLibrary library;    
}