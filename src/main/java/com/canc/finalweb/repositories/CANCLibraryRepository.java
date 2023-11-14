package com.canc.finalweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.canc.finalweb.models.CANCLibrary;

public interface CANCLibraryRepository extends CrudRepository<CANCLibrary, Long> {

    CANCLibrary findByName(String name);
    
}
