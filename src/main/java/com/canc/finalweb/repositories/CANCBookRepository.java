package com.canc.finalweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.canc.finalweb.models.CANCBook;

@Repository
public interface CANCBookRepository extends CrudRepository<CANCBook, Long> {

    CANCBook findByName(String name);

}
