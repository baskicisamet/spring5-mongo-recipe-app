package com.sam.spring5mongorecipeapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sam.spring5mongorecipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category,String> {


    Optional<Category> findByDescription(String description);
}
