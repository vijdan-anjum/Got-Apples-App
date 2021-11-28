package comp3350.got_apples.logic;


import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

import comp3350.got_apples.application.Main;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.objects.Ingredient;
import comp3350.got_apples.objects.IngredientList;
import comp3350.got_apples.objects.Recipe;
import comp3350.got_apples.persistence.RecipeInterface;
import comp3350.got_apples.persistence.hsqldb.RecipeHSQLDB;
import comp3350.got_apples.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;


public class RecipeHandlerIT{
    private RecipeHandler recipeHandler;
    private File tempDB;
    private ArrayList<Recipe> recipeList;


    @Before
    public void setup() throws IOException{
        System.out.println("Starting integration testing for RecipeHandler!");

        this.tempDB = TestUtils.copyDB();
        final RecipeHSQLDB db = new RecipeHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.recipeHandler = new RecipeHandler(db);

        recipeList = db.getRecipeList();

    }

    @Test
    public void testDatabase() throws InvalidInputException {

        assertTrue("Testing if the database is accessed.",recipeList.size() == 22);

        System.out.println("User has set of ingredients that should match 100% with one Recipe and almost match with another Recipe\n");

        IngredientList testFirstIngredientList = new IngredientList();
        testFirstIngredientList.addIngredient(new Ingredient("eggs"));
        testFirstIngredientList.addIngredient(new Ingredient("milk"));
        testFirstIngredientList.addIngredient(new Ingredient("salt"));
        Recipe testFirstRecipe = new Recipe("Scrambled eggs", "English", testFirstIngredientList, "Heat olive oil in a large skillet over medium-high heat. Season beef chuck roast with salt and pepper. Cook roast in hot oil until browned entirely 2 to 3 minutes per side; transfer browned roast to a slow cooker. Sprinkle onion chile pepper hot sauce taco seasoning chili powder cayenne pepper and garlic powder over the roast. Cook on Low until meat is fall-apart tender 8 to 10 hours.");

        System.out.println("Testing if the first Recipe is the same as the one in the database");
        assertEquals(testFirstRecipe.getInstructions(), recipeList.get(0).getInstructions());
        assertEquals(testFirstRecipe.getCuisineType(), recipeList.get(0).getCuisineType());
        assertEquals(testFirstRecipe.getRecipeName(), recipeList.get(0).getRecipeName());


        int n = recipeList.get(0).getListOfIngredients().getSize();
        for(int i=0; i< n; i++){
            assertTrue(testFirstRecipe.getListOfIngredients().getIngredient(i)
                    .isEqual(recipeList.get(0).getListOfIngredients().getIngredient(i)));
        }
        System.out.println("\tEnd of testDatabase().");
    }

    @Test
    public void testGetMatchedRecipes() throws InvalidInputException {
        CurrentUser testUser = new CurrentUser("testUserName23", "testPassword23");


        IngredientList testIngredientList = new IngredientList();
        testIngredientList.addIngredient(new Ingredient("eggs"));
        testIngredientList.addIngredient(new Ingredient("salt"));
        testIngredientList.addIngredient(new Ingredient("shredded cheese"));
        testIngredientList.addIngredient(new Ingredient("milk"));
        testUser.setIngredientList(testIngredientList);
        testUser.setCuisine("All");

        ArrayList<ArrayList<Recipe>> result = recipeHandler.getMatchedRecipes(testUser);

        System.out.println("Checking if the matched recipes are Scrambled eggs, Scrambled" +
                "egg with cheese, and Fried egg");

        String[] resultString = {"Scrambled eggs~ 100% Match", "Scrambled eggs with cheese~ 100% Match",
                "Fried egg~ Almost Match"};
        assertEquals(resultString, recipeHandler.getRecipeNames(result));

        System.out.println("\tEnd of testGetMatchedRecipes().");
    }

    @Test
    public void testGetRecipe() throws InvalidInputException{
        CurrentUser testUser = new CurrentUser("testUserName23", "testPassword23");


        IngredientList testIngredientList = new IngredientList();
        testIngredientList.addIngredient(new Ingredient("eggs"));
        testIngredientList.addIngredient(new Ingredient("salt"));
        testIngredientList.addIngredient(new Ingredient("shredded cheese"));
        testIngredientList.addIngredient(new Ingredient("milk"));
        testUser.setIngredientList(testIngredientList);
        testUser.setCuisine("All");

        ArrayList<ArrayList<Recipe>> recipeListResult = recipeHandler.getMatchedRecipes(testUser);

        Recipe recipeResult = recipeHandler.getRecipe("Scrambled eggs", recipeListResult);

        assertTrue(recipeResult.getRecipeName().equals("Scrambled eggs"));

        System.out.println("\tEnd of testGetRecipe.");
    }
}
