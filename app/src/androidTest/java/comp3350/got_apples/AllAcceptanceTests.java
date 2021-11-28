package comp3350.got_apples;

import androidx.test.filters.LargeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.got_apples.presentation.RecipeAcceptanceTest;

@LargeTest
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                RecipeAcceptanceTest.class
        }
)

public class AllAcceptanceTests
{

}