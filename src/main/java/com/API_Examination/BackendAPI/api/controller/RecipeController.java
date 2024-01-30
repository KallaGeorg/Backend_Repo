package com.API_Examination.BackendAPI.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API_Examination.BackendAPI.api.model.Recipe;
import com.API_Examination.BackendAPI.repository.RecipeRepository;

@RestController
public class RecipeController {
    
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String getData(){
        return "Data successfully received";
    }
    @PostMapping("/")
    public ResponseEntity<String> displayData(@RequestBody String data){
        System.out.println("D a a T a: "+ data);
        String jsonResponse = "{\"message\": \"Data successfully received\"}";
        return ResponseEntity.ok(jsonResponse);
    }
    @PostMapping("/recipes")
    public ResponseEntity<Map<String, String>> addRecipe(@RequestBody Recipe recipe){
        recipeRepository.save(recipe);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Recipe successfully added");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
