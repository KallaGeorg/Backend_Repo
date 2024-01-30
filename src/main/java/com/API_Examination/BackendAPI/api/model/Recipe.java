package com.API_Examination.BackendAPI.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recipe_table")
public class Recipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String mealName;
private String recipe;
private String comment;

public Recipe(int id, String mealName, String recipe, String comment){
    this.id = id;
    this.mealName = mealName;
    this.recipe = recipe;
    this.comment = comment;
}
public Recipe(){
    
}

public int getId() {
    return id; 
}

public void setId(int id) {
    this.id = id;
}

public String getMealName() {
    return mealName;
}

public void setMealName(String mealName) {
    this.mealName = mealName;
}

public String getRecipe() {
    return recipe;
}

public void setRecipe(String recipe) {
    this.recipe = recipe;
}

public String getComment() {
    return comment;
}

public void setComment(String comment) {
    this.comment = comment;
}
    
}
