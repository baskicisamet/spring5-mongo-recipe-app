package com.sam.spring5mongorecipeapp.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sam.spring5mongorecipeapp.commands.RecipeCommand;
import com.sam.spring5mongorecipeapp.converters.RecipeCommandToRecipe;
import com.sam.spring5mongorecipeapp.converters.RecipeToRecipeCommand;
import com.sam.spring5mongorecipeapp.domain.Recipe;
import com.sam.spring5mongorecipeapp.exceptions.NotFoundException;
import com.sam.spring5mongorecipeapp.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private RecipeCommandToRecipe recipeCommandToRecipe;
    private RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(String id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw  new NotFoundException("Recipe Not Found, for ID value  : " + id.toString());
        }
        return recipeOptional.get();
    }

    @Override
    public RecipeCommand findCommandById(String l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId : " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    public void deleteById(String idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }


}
