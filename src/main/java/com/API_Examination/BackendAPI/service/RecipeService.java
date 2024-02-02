package com.API_Examination.BackendAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.API_Examination.BackendAPI.api.model.Recipe;
import com.API_Examination.BackendAPI.repository.RecipeRepository;



@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
   
    @Transactional
    public void deleteMealByName(String mealName){
        recipeRepository.deleteByMealName(mealName);
    }
    @Transactional(readOnly = true)
    public Recipe getRecipeByName(String mealName){
        Optional<Recipe> recipeOptional = recipeRepository.findMealByName(mealName);
        return recipeOptional.orElse(null);
    }

    @Transactional
    public void saveRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }
    
}
