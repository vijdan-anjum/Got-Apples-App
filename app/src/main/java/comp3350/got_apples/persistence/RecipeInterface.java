package comp3350.got_apples.persistence;

import java.util.ArrayList;

import comp3350.got_apples.objects.Recipe;

public interface RecipeInterface {

    ArrayList<Recipe> getRecipeList();
    Recipe getRecipeFromName(String recipeName);
}
