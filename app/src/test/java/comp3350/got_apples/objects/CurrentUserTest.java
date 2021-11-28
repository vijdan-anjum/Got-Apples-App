package comp3350.got_apples.objects;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;

public class CurrentUserTest {

    @Before
    public void setup(){
        System.out.println("Starting unit tests for CurrentUser object");
    }

    @Test
    public void testUsernameGetAndSetMethods() throws InvalidInputException {
        System.out.println("\n\nChecking if the user's name can be changed with the" +
                " method setUserName(String), and if it is returned with the method getUserName().");

        CurrentUser currentUser1 = new CurrentUser("userTester", "PasswordTest3");
        currentUser1.setUserName("Mario_Luigi");

        String userName = currentUser1.getUserName();

        assertEquals("Mario_Luigi", userName); // checks if get and set method works

        System.out.println("\tEnd of testUsernameGetAndSetMethods().");
    }

    @Test
    public void testPasswordGetAndSetMethods() {
        System.out.println("\nChecking if the user's password can be changed with the" +
                " method setPassword(String), and if it is returned with the method getPassword().");

        CurrentUser currentUser2 = new CurrentUser();
        currentUser2.setPassword("qwertyuiop1234567890");

        String userPassword = currentUser2.getPassword();

        assertEquals("qwertyuiop1234567890", userPassword );

        System.out.println("\tEnd of testPasswordGetAndSetMethods.");
    }

    @Test
    public void testCuisineGetAndSetMethods() {
        System.out.println("\nChecking if the user's cuisine can be changed with the" +
                " method setCuisine(String), and if it is returned with the method getCuisine().");

        CurrentUser currentUser3 = new CurrentUser();
        currentUser3.setCuisine("Chinese Cuisine");

        String userChosenCuisine = currentUser3.getCuisine();

        assertEquals("Chinese Cuisine", userChosenCuisine);

        System.out.println("\tEnd of testCuisineGetAndSetMethods().");
    }


    @Test
    public void testIngredientListGetAndSetMethods() throws InvalidInputException {
        System.out.println("\nChecking if the user's ingredients List can be changed with the" +
                " method setIngredientsInFridge(ArrayList<> Ingredient), and if it is returned with " +
                "the method getIngredientsInFridge().");

        IngredientList testIngredients = new IngredientList();
        testIngredients.addIngredient(new Ingredient("tomatoes"));
        testIngredients.addIngredient(new Ingredient("potatoes"));

        CurrentUser currentUser4 = new CurrentUser();
        currentUser4.setIngredientList(testIngredients);

        assertEquals("tomatoes", (testIngredients.getIngredient(0)).getIngredient() );
        assertEquals("potatoes", (testIngredients.getIngredient(1)).getIngredient() );

        assertEquals(testIngredients, currentUser4.getIngredientList());

        System.out.println("\tEnd of testIngredientListGetAndSetMethods().");
    }

}