package com.sam.spring5mongorecipeapp.domain;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {

 
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;

   
    private String directions;

    
    private Difficulty difficulty;

   
    private Set<Ingredient> ingredients = new HashSet<>();

   
    private  Byte[] image;

    
    private Notes notes;

  
    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes) {
        if(notes != null){
            this.notes = notes;
            notes.setRecipe(this);
        }

    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }


}
