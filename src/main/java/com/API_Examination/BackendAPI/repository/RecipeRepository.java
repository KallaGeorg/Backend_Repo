package com.API_Examination.BackendAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.API_Examination.BackendAPI.api.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer > {
    
}
