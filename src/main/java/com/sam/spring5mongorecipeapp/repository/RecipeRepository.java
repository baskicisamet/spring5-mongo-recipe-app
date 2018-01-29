package com.sam.spring5mongorecipeapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.spring5mongorecipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,String>{
}
