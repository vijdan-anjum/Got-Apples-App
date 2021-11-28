package comp3350.got_apples;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.got_apples.logic.RecipeHandlerIT;
import comp3350.got_apples.logic.RegisterHandler;
import comp3350.got_apples.logic.RegisterHandlerIT;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            RecipeHandlerIT.class,
            RegisterHandlerIT.class
        }
)

public class  AllIntegrationTests
{

}