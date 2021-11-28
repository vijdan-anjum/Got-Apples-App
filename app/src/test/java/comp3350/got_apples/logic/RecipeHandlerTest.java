package comp3350.got_apples.logic;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import comp3350.got_apples.application.Services;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.objects.Recipe;
import comp3350.got_apples.persistence.RecipeInterface;

public class RecipeHandlerTest extends TestCase {


    @Test
    public void testMatchRecipeIngredients() {


        RecipeHandler recipeHandler = new RecipeHandler(false);
        CurrentUser currentUser = new CurrentUser();
        IngredientList ingredientList = new IngredientList("eggs|milk|salt|sausage|pepper");
        String cuisine = "All";
        currentUser.setIngredientList(ingredientList);
        currentUser.setCuisine(cuisine);

        ArrayList<ArrayList<Recipe>> matchedList = recipeHandler.getMatchedRecipes(currentUser);

        IngredientList ingList0 = new IngredientList();
        ingList0.addIngredient("eggs");
        ingList0.addIngredient("milk");
        ingList0.addIngredient("salt");
        Recipe recipe0 = new Recipe("Scrambled eggs", "English", ingList0, "fry and scramble stuff");
        ArrayList<Recipe> expectedList0 = new ArrayList<>();
        expectedList0.add(recipe0);

        IngredientList ingList1 = new IngredientList();
        ingList1.addIngredient("eggs");
        ingList1.addIngredient("bread");
        ingList1.addIngredient("sausage");
        ingList1.addIngredient("pepper");
        ingList1.addIngredient("oil");
        ingList1.addIngredient("salt");
        Recipe recipe1 = new Recipe("English Breakfast", "English", ingList1, "fry and do stuff");
        ArrayList<Recipe> expectedList1 = new ArrayList<>();
        expectedList1.add(recipe1);

        ArrayList<ArrayList<Recipe>> finalExpectedList = new ArrayList<>();
        finalExpectedList.add(expectedList0);
        finalExpectedList.add(expectedList1);



        System.out.println("Matched list contains two lists, Index 0: is the 100% match and index 1 is the Almost Match where user was 1 or 2 ingredients away");

        for(int i=0; i<finalExpectedList.size(); i++){
            for(int j=0; j<finalExpectedList.get(i).size(); j++){
                Recipe expectedRecipe = finalExpectedList.get(i).get(j);
                Recipe matchedRecipe = matchedList.get(i).get(j);
                assertTrue(expectedRecipe.getRecipeName().equals(matchedRecipe.getRecipeName()));
                assertTrue(expectedRecipe.getCuisineType().equals(matchedRecipe.getCuisineType()));
                assertTrue(expectedRecipe.getStringIngredientsList().equals(matchedRecipe.getStringIngredientsList()));
                assertTrue(expectedRecipe.getInstructions().equals(matchedRecipe.getInstructions()));
            }
        }
        System.out.println("Successfully checked that both lists match up");
    }


    public void testGetRecipeNames() {

        RecipeHandler recipeHandler = new RecipeHandler(false);
        CurrentUser currentUser = new CurrentUser();
        IngredientList ingredientList = new IngredientList("eggs|milk|salt|sausage|pepper");
        String cuisine = "All";
        currentUser.setIngredientList(ingredientList);
        currentUser.setCuisine(cuisine);

        ArrayList<ArrayList<Recipe>> matchedList = recipeHandler.getMatchedRecipes(currentUser);
        String[] matchedListArr = recipeHandler.getRecipeNames(matchedList);

        String[] expectedResult = {"Scrambled eggs~ 100% Match", "English Breakfast~ Almost Match"};

        System.out.println("Checking if the length of the expected and the result array is the same:");
        assertEquals(matchedListArr.length, expectedResult.length);
        System.out.println("Successfully checked.");


        System.out.println("Checking if the contents of the array are the same");
        for(int s=0; s<expectedResult.length; s++){
            assertEquals(expectedResult[s],matchedListArr[s]);
        }
        System.out.println("Successfully checked.");
    }


    public void testGetRecipe() {

        RecipeHandler recipeHandler = new RecipeHandler(false);
        CurrentUser currentUser = new CurrentUser();
        IngredientList ingredientList = new IngredientList("eggs|milk|salt|sausage|pepper");
        String cuisine = "All";
        currentUser.setIngredientList(ingredientList);
        currentUser.setCuisine(cuisine);

        ArrayList<ArrayList<Recipe>> matchedList = recipeHandler.getMatchedRecipes(currentUser);

        String recipe0 = "Scrambled eggs";
        String recipe1 = "English Breakfast";

        assertNotNull(recipeHandler.getRecipe(recipe0,matchedList));
        assertNotNull(recipeHandler.getRecipe(recipe1,matchedList));
    }

}