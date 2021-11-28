package comp3350.got_apples.persistence.stubs;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.objects.Recipe;
import comp3350.got_apples.persistence.RecipeInterface;

public class RecipeStub implements RecipeInterface {

    ArrayList<Recipe> recipeDatabase;

    public RecipeStub() {
        this.recipeDatabase = createRecipeDatabase();
    }

    @Override
    public ArrayList<Recipe> getRecipeList() {
        return recipeDatabase;
    }

    private ArrayList<Recipe> createRecipeDatabase() {

        ArrayList<Recipe> thisRecipeDatabase = new ArrayList<>();

        IngredientList ingList0 = new IngredientList();
        ingList0.addIngredient("eggs");
        ingList0.addIngredient("mushrooms");
        ingList0.addIngredient("olives");
        ingList0.addIngredient("tomatoes");
        ingList0.addIngredient("oil");
        ingList0.addIngredient("salt");
        Recipe recipe0 = new Recipe("Italian Omelette", "Italian", ingList0, "fry and do stuff");


        IngredientList ingList1 = new IngredientList();
        ingList1.addIngredient("eggs");
        ingList1.addIngredient("bread");
        ingList1.addIngredient("sausage");
        ingList1.addIngredient("pepper");
        ingList1.addIngredient("oil");
        ingList1.addIngredient("salt");
        Recipe recipe1 = new Recipe("English Breakfast", "English", ingList1, "fry and do stuff");

        IngredientList ingList2 = new IngredientList();
        ingList2.addIngredient("eggs");
        ingList2.addIngredient("milk");
        ingList2.addIngredient("salt");
        Recipe recipe2 = new Recipe("Scrambled eggs", "English", ingList2, "fry and scramble stuff");

        thisRecipeDatabase.add(recipe0);
        thisRecipeDatabase.add(recipe1);
        thisRecipeDatabase.add(recipe2);

        return thisRecipeDatabase;
    }

    @Override
    public Recipe getRecipeFromName(String recipeName) {

        Recipe foundRecipe = null;

        for (Recipe recipe : recipeDatabase) {
            if (recipe.getRecipeName().equals(recipeName)) {
                foundRecipe = recipe;
            }
        }
        return foundRecipe;
    }
}