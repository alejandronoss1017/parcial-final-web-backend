package com.canc.finalweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.canc.finalweb.models.CANCBook;

public interface CANCBookRepository extends CrudRepository<CANCBook, Long> {

    CANCBook findByName(String name);

}
