package comp3350.got_apples.objects;

import java.io.Serializable;

public class Recipe implements Serializable {

    private int id;
    private String recipeName;
    private String cuisineType;
    private IngredientList listOfIngredients;
    private String instructions;

    public Recipe() {}

    public Recipe(String recipeName, String cuisineType, IngredientList listOfIngredients, String instructions) {
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
        this.listOfIngredients = listOfIngredients;
        this.instructions = instructions;
    }

    public Recipe(int id, String recipeName, String cuisineType, IngredientList listOfIngredients, String instructions) {
        this.id = id;
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
        this.listOfIngredients = listOfIngredients;
        this.instructions = instructions;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public IngredientList getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(IngredientList listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    public String getStringIngredientsList(){
        String[] ingredientsArray =  listOfIngredients.getStringArray();
        String string = "";
        for(String s: ingredientsArray){
            string += s + "\n";
        }
        return string;
    }
}
