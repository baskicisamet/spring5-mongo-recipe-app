package com.sam.spring5mongorecipeapp.repository.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sam.spring5mongorecipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String>{
	

}
