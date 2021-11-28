package comp3350.got_apples;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.got_apples.logic.RecipeHandlerTest;
import comp3350.got_apples.objects.IngredientListTest;
//import comp3350.got_apples.logic.RecipeHandlerTest;
import comp3350.got_apples.objects.CurrentUserTest;
import comp3350.got_apples.objects.IngredientTest;
import comp3350.got_apples.objects.RecipeTest;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                CurrentUserTest.class,
                IngredientTest.class,
                IngredientListTest.class,
                RecipeHandlerTest.class,
                RecipeTest.class

        }
)

public class  AllUnitTests
{


}