package comp3350.got_apples.objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.Ingredient;

public class IngredientTest{

    @Before
    public void setup(){
        System.out.println("Starting unit tests for Ingredient object");
    }

    // Tests both

    @Test
    public void testIngredientInput() {
        System.out.println("\nChecking if a String is returned and whitespaces before and " +
                "after ingredients are cleared, and an empty String should be thrown");

        Ingredient newIngredient = null;
        Ingredient newIngredient2 = null;
        try {
            newIngredient = new Ingredient("           bacon                      ");
            newIngredient2 = new Ingredient("");    // should be thrown
        } catch (InvalidInputException e) {
            assertEquals(e.getMessage(), "No ingredient provided");
        }

        String ingredient1 = newIngredient.getIngredient();
        String ingredient2 = "bacon";

        assertEquals(ingredient1, ingredient2);

        System.out.println("\tEnd of testIngredientTrim().");
    }


    @Test
    public void testIngredientToLowerCase(){
        System.out.println("\nChecking if a String is returned and if uppercase characters " +
                "are converted to lowercase characters.");

        Ingredient newIngredient = null;
        try {
            newIngredient = new Ingredient("cAviAr");
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        String ingredient1 = newIngredient.getIngredient();
        String ingredient2 = "caviar";

        assertEquals(ingredient1, ingredient2);

        System.out.println("\tEnd of testIngredientToLowerCase().");
    }

    @Test
    public void testisEqual(){
        try {
            Ingredient thisIngredient = new Ingredient("eggs");
            Ingredient otherIngredient = new Ingredient("not eggs");
            Ingredient moreEggs = new Ingredient("eggs");

            assertFalse(thisIngredient.isEqual(otherIngredient) );
            assertTrue(thisIngredient.isEqual(moreEggs) );

        } catch (InvalidInputException e) {
            assertEquals(e.getMessage(), "No ingredient provided");
        }

        System.out.println("\tEnd of testisEqual().");
    }
}
