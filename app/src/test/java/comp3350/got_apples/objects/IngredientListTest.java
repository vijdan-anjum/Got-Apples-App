package comp3350.got_apples.objects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;

import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.IngredientList;

import static org.mockito.Mockito.*;

public class IngredientListTest {
    /**
     * USING MOCKITO TO TEST THE NEWLY IMPLEMENTED IngredientList Object
     */

    // Instance Variables
    private IngredientList ingredMockedList;
    private IngredientList strIngredMockedList;

    @Before
    public void setup() {
        ingredMockedList = mock(IngredientList.class);
        strIngredMockedList = mock(IngredientList.class);
    }

    @Test
    public void testIngredientList() throws InvalidInputException {

        ArrayList<Ingredient> mockedListCheck = null;
        Ingredient newIngredient = new Ingredient("eggs");
        Ingredient newIngredient2 = new Ingredient("tomatoes");
        String emptyIngredient = "";

        // testing empty constructor
        ingredMockedList = spy(new IngredientList());
        ingredMockedList.addIngredient(newIngredient);
        verify(ingredMockedList).addIngredient(newIngredient);
        assertFalse(ingredMockedList == null);

        // checking that addIngredient(Ingredient) works
        verify(ingredMockedList).addIngredient(newIngredient);
        assertTrue(ingredMockedList.contains(newIngredient));

        // checking that getIngredient works
        Ingredient ingredientComparator;
        ingredientComparator = ingredMockedList.getIngredient(0);
        verify(ingredMockedList).getIngredient(0);
        assertEquals(ingredientComparator, newIngredient);

        // checking that getSize works
        int size = ingredMockedList.getSize();
        verify(ingredMockedList).getSize();
        assertFalse(size == 0);
        assertTrue(size == 1);

        // checking that getIngredientArrayList has been used and works
        mockedListCheck = ingredMockedList.getIngredientArrayList();
        verify(ingredMockedList).getIngredientArrayList();
        assertFalse(mockedListCheck == null);

        // checking that setIngredientArrayList works
        ingredMockedList.addIngredient(newIngredient2);
        mockedListCheck.add(newIngredient2);
        ingredMockedList.setIngredientArrayList(mockedListCheck);
        verify(ingredMockedList).setIngredientArrayList(mockedListCheck);

        // checking that removeIngredient works
        assertEquals(ingredMockedList.getIngredient(0), newIngredient);
        ingredMockedList.removeIngredient(0);
        verify(ingredMockedList).removeIngredient(0);
        assertNotEquals(ingredMockedList.getIngredient(0), newIngredient);



        // testing String to IngredientList constructor
        strIngredMockedList = spy(new IngredientList("milk|bokchoy|canola oil") );
        assertFalse(strIngredMockedList == null);


        // checking that addIngredient(String) works
        strIngredMockedList.addIngredient("olive oil");
        verify(strIngredMockedList).addIngredient("olive oil");

        String stringResult = strIngredMockedList.toString();
        assertEquals(stringResult, "[milk, bokchoy, canola oil, olive oil]");

        System.out.println("End of testIngredientList().");
    }
}
