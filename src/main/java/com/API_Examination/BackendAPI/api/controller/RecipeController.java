package com.API_Examination.BackendAPI.api.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API_Examination.BackendAPI.api.model.Recipe;
import com.API_Examination.BackendAPI.repository.RecipeRepository;
import com.API_Examination.BackendAPI.service.RecipeService;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
public class RecipeController {
    
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
    @Autowired
    RecipeService recipeService;

    @GetMapping("/mealNames")
     public List<String> getAllMealNames(){ 
     return recipeRepository.findAllMealNames();
    }
        
    @GetMapping("/mealNames/{mealName}")
    public ResponseEntity<Recipe> getRecipebyName(@PathVariable String mealName){
        Optional<Recipe> optionalRecipe = recipeRepository.findMealByName(mealName);
        if(optionalRecipe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Recipe recipe = optionalRecipe.get();
        return ResponseEntity.ok(recipe);
    }
   
    @PostMapping("/recipes")
    public Recipe addRecipes(@RequestBody Recipe recipe){
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe;
    }
    @DeleteMapping("/mealNames/{mealName}")
    public ResponseEntity<?> deleteMeal(@PathVariable String mealName){
    try{
   
    recipeService.deleteMealByName(mealName);
    return ResponseEntity.ok().build();
    }catch (Exception e){
       
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting meal"+e.getMessage());
    }
    }
    @PatchMapping("/mealNames/{mealName}")
    public ResponseEntity<?> updateMeal(@PathVariable String mealName, @RequestBody Recipe updatedRecipe){
        Recipe existingRecipe = recipeService.getRecipeByName(mealName);
        if(existingRecipe == null){
            return ResponseEntity.notFound().build();
        }
        existingRecipe.setMealName(updatedRecipe.getMealName());
        existingRecipe.setRecipe(updatedRecipe.getRecipe());
        existingRecipe.setComment(updatedRecipe.getComment());
        recipeService.saveRecipe(existingRecipe);
      return ResponseEntity.ok().body(existingRecipe);  
    }
}
