package com.canc.finalweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.canc.finalweb.models.CANCLibrary;

@Repository
public interface CANCLibraryRepository extends CrudRepository<CANCLibrary, Long> {

    CANCLibrary findByName(String name);

}
