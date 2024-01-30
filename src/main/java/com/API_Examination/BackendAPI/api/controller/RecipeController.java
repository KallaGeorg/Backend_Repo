package com.API_Examination.BackendAPI.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
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
    
}
