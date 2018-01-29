package com.sam.spring5mongorecipeapp.service;

import java.util.Set;

import com.sam.spring5mongorecipeapp.commands.RecipeCommand;
import com.sam.spring5mongorecipeapp.domain.Recipe;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
