package com.sam.spring5mongorecipeapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sam.spring5mongorecipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,String> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
