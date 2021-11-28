package comp3350.got_apples.objects;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;

import comp3350.got_apples.logic.exceptions.InvalidInputException;

public class RecipeTest extends TestCase {
    private final int id = 12345;
    private final String recipeName = "Omelette";
    private final String cuisineType = "Persian";

    private IngredientList testIngredients = new IngredientList();

    private final String procedure = "1. Prep the eggs. \n " +
            "2. Melt the butter. \n " +
            "3. Add the eggs and cook the omelette. \n " +
            "4. Fill the omelette. \n " +
            "5. Fold and plate the omelette.";

    @Before
    public void setUp() {

        System.out.println("\n\nStarting unit tests for Recipe object");

        try {
            testIngredients.addIngredient(new Ingredient("eggs"));
            testIngredients.addIngredient(new Ingredient("grated cheese"));
            testIngredients.addIngredient(new Ingredient("parsley"));
            testIngredients.addIngredient(new Ingredient("unsalted butter"));

        } catch (InvalidInputException e) {
            e.getMessage();
        }

    }


    public void testGetId() {
        System.out.println("\nChecking if ID is being returned with the method getId()");

        Recipe recipeTest1 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        assertEquals(12345, recipeTest1.getId());

        System.out.println("\ttestGetId() run successfully.");
    }


    public void testSetId() {
        System.out.println("\nChecking if ID can be set with the method setId(String)");

        Recipe recipeTest2 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);

        recipeTest2.setId(1823672);
        assertEquals(1823672, recipeTest2.getId());

        System.out.println("\ttestSetId() run successfully.");
    }

    /**
     * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
     * For each method afterwards, we're going to test both constructors in Recipe,
     * one with id and one without!
     * recipeTest variables have a string id as a parameter.
     * recipeTestParam2 variables does not have string id as a parameter.
     * -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
     */

    public void testGetRecipeName() {
        System.out.println("\nChecking if recipe name is being returned with method getRecipeName() )");

        Recipe recipeTest3 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest3Param2 = new Recipe(recipeName + "SSS", cuisineType, testIngredients, procedure);

        assertEquals("Omelette", recipeTest3.getRecipeName());
        assertEquals("OmeletteSSS", recipeTest3Param2.getRecipeName());

        System.out.println("\ttestGetRecipeName() run successfully.");
    }


    public void testSetRecipeName() {
        System.out.println("\nChecking if recipe name can be set with the method setRecipeName(String)");

        Recipe recipeTest4 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest4Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure);

        recipeTest4.setRecipeName("Barbecue");
        recipeTest4Param2.setRecipeName("Barbecues!");

        assertEquals("Barbecue", recipeTest4.getRecipeName());
        assertEquals("Barbecues!", recipeTest4Param2.getRecipeName());

        System.out.println("\ttestSetRecipeName() run successfully.");
    }


    public void testGetCuisineType() {
        System.out.println("\nChecking if cuisine type is being returned with method getCuisineType()");

        Recipe recipeTest5 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest5Param2 = new Recipe(recipeName, cuisineType + " Greek", testIngredients, procedure);

        assertEquals("Persian", recipeTest5.getCuisineType());
        assertEquals("Persian Greek", recipeTest5Param2.getCuisineType());


        System.out.println("\ttestGetCuisineType() run successfully.");
    }


    public void testSetCuisineType() {
        System.out.println("\nChecking if cuisine type can be set with the method setCuisineType(String)");

        Recipe recipeTest6 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest6Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure);
        recipeTest6.setCuisineType("English");
        recipeTest6Param2.setCuisineType("Canadian");

        assertEquals("English", recipeTest6.getCuisineType());
        assertEquals("Canadian", recipeTest6Param2.getCuisineType());

        System.out.println("\ttestSetCuisineType() run successfully.");
    }


    public void testGetListOfIngredients() {
        System.out.println("\nChecking if the list of ingredients is being returned with the method getListOfIngredients()");

        IngredientList newIngredients = new IngredientList();
        Recipe recipeTest7 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest7Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure);

        assertEquals(testIngredients, recipeTest7.getListOfIngredients());

        try {
            newIngredients.addIngredient(new Ingredient("ketchup"));
            testIngredients.addIngredient(new Ingredient("ketchup"));
        }

        catch (InvalidInputException e) {
            e.getMessage();
        }

        assertEquals(testIngredients, recipeTest7Param2.getListOfIngredients());

        System.out.println("\ttestGetListOfIngredients() run successfully.");
    }


    public void testSetListOfIngredients() {
        System.out.println("\nChecking if the list of ingredients can be set with the method setListOfIngredients(IngredientList)");

        IngredientList newListOfIngredients = new IngredientList();
        try {
            newListOfIngredients.addIngredient(new Ingredient("lactose"));
            newListOfIngredients.addIngredient(new Ingredient("glucose"));
            newListOfIngredients.addIngredient(new Ingredient("fructose"));
            newListOfIngredients.addIngredient(new Ingredient("sucrose"));

        } catch (InvalidInputException e) {
            e.getMessage();
        }


        Recipe recipeTest8 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest8Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure);

        recipeTest8.setListOfIngredients(newListOfIngredients);
        assertEquals(newListOfIngredients, recipeTest8.getListOfIngredients());

        try {
            newListOfIngredients.addIngredient(new Ingredient("galactose"));

        } catch (InvalidInputException e) {
            e.getMessage();
        }
        recipeTest8Param2.setListOfIngredients(newListOfIngredients);
        assertEquals(newListOfIngredients, recipeTest8Param2.getListOfIngredients());

        System.out.println("\ttestSetListOfIngredients() run successfully.");
    }


    public void testGetProcedure() {
        System.out.println("\nChecking if procedure is being returned with the method getProcedure()");

        String testProcedure = "1. Prep the eggs. \n " +
                "2. Melt the butter. \n " +
                "3. Add the eggs and cook the omelette. \n " +
                "4. Fill the omelette. \n " +
                "5. Fold and plate the omelette.";

        Recipe recipeTest9 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest9Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure + "\n6. Go eat your omelette!");

        assertEquals(testProcedure, recipeTest9.getInstructions());
        assertEquals(testProcedure + "\n6. Go eat your omelette!", recipeTest9Param2.getInstructions());


        System.out.println("\ttestGetProcedure() run successfully.");
    }


    public void testSetProcedure() {
        System.out.println("\nChecking if procedure can be set with setProcedure(String)");

        String testProcedure = "DON'T COOK OMELETTES THEY ARE BAD FOR EVERYONE!";
        Recipe recipeTest10 = new Recipe(id, recipeName, cuisineType, testIngredients, procedure);
        Recipe recipeTest10Param2 = new Recipe(recipeName, cuisineType, testIngredients, procedure);

        recipeTest10.setInstructions(testProcedure);
        recipeTest10Param2.setInstructions(testProcedure + "PLEASE BELIEVE ME!");

        assertEquals(testProcedure, recipeTest10.getInstructions());
        assertEquals(testProcedure + "PLEASE BELIEVE ME!", recipeTest10Param2.getInstructions());

        System.out.println("\ttestSetProcedure() run successfully.");
    }

    public void testGetStringIngredientsList(){
        System.out.println("\nChecking if we can get the list of ingredients from a recipe");

        Recipe testRecipe = new Recipe(id,recipeName,cuisineType,testIngredients,procedure);
        String result = "";

        result = testRecipe.getStringIngredientsList();
        assertEquals(result, "eggs\ngrated cheese\nparsley\nunsalted butter\n");

        System.out.println("\ttestGetStringIngredientsList run successfully.");
    }
}