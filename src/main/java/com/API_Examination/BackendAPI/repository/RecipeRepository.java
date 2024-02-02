package com.API_Examination.BackendAPI.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.API_Examination.BackendAPI.api.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer > {
@Query("SELECT DISTINCT r.mealName FROM Recipe r")
List<String> findAllMealNames();
@Query("SELECT r FROM Recipe r WHERE r.mealName = :mealName")
Optional<Recipe> findMealByName(String mealName);
   
    void deleteByMealName(String mealName);
    
}
