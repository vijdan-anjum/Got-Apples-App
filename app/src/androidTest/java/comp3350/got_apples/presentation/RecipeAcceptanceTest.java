package comp3350.got_apples.presentation;


import android.os.SystemClock;
import android.view.KeyEvent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import comp3350.got_apples.R;
import comp3350.got_apples.application.Services;
import comp3350.got_apples.logic.RegisterHandler;
import comp3350.got_apples.logic.exceptions.InvalidInputException;
import comp3350.got_apples.objects.CurrentUser;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class RecipeAcceptanceTest {
    private String[] ingredientsArray;
    private final int pauseTime = 500;      // slows down the acceptance testing

    @Rule
    public ActivityTestRule<HomeActivity>activityTestRule = new ActivityTestRule<>(HomeActivity.class);


    @Test
    public void fullAcceptanceTest() throws InvalidInputException {
        /**
         * THIS INCLUDES ADDING AND REMOVING AN INGREDIENT, REPETITIVE INGREDIENTS SHOULD NOT
         * BE ACCEPTED, AND ACTIVITY SHOULD NOT MOVE FORWARD IF THERE ARE NO INGREDIENTS.
         */

        SystemClock.sleep(3020);    // wait for it to load

        // doing the right register and login because that is not what we care about for this test
        CurrentUser userName = new CurrentUser("testUsername", "testPassword1");
        RegisterHandler handler = new RegisterHandler(true);

        if(!handler.isExistingUser(userName)) {
            onView(ViewMatchers.withId(R.id.login_register_Button)).perform(click());
            onView(ViewMatchers.withId(R.id.register_Email_Input)).perform(typeText("testUsername"));
            onView(ViewMatchers.withId(R.id.register_Password_Input)).perform(typeText("testPassword1"));
            onView(ViewMatchers.withId(R.id.register_rePassword_Input)).perform(typeText("testPassword1"));
            closeSoftKeyboard();
            SystemClock.sleep(pauseTime);
            onView(ViewMatchers.withId(R.id.register_register_Button)).perform(click());
        }

        else{
            onView(ViewMatchers.withId(R.id.login_Email_Input)).perform(typeText("testUsername"));
            onView(ViewMatchers.withId(R.id.login_Password_Input)).perform(typeText("testPassword1"));
            closeSoftKeyboard();
            onView(ViewMatchers.withId(R.id.login_Login_Button)).perform(click());
        }

        // should bring out a message saying to input an ingredient
        onView(ViewMatchers.withId(R.id.next_button)).perform(click());
        SystemClock.sleep(pauseTime);
        pressBack();

        // inputting eggs to the text and adding it to the ingredients List
        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("eggs"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());
        SystemClock.sleep(pauseTime);

        // make sure there's eggs seen, then delete it!
        onView(ViewMatchers.withId(R.id.ingredients_List)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.ingredients_List)).perform(click());
        SystemClock.sleep(pauseTime);

        onView(withText("Yes"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());

        // add eggs again
        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("eggs"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());
        SystemClock.sleep(pauseTime);

        // extra input should not be added
        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("eggs"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());
        SystemClock.sleep(pauseTime);

        onView(withId(R.id.ingredients_Input))
                .perform(replaceText("eggs"))
                .perform(click())
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL));


        // just to check if activity passes over to the next activity
        onView(ViewMatchers.withId(R.id.next_button)).perform(click());
        SystemClock.sleep(pauseTime);

        // ALL
        onView(withId(R.id.cuisine1)).perform(click());
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine1)).check(matches(isDisplayed()));

        // Italian
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine2)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine2)).check(matches(isDisplayed()));

        // Mexican
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine3)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine3)).check(matches(isDisplayed()));

        // Swedish
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine4)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine4)).check(matches(isDisplayed()));

        // English
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine5)).perform(click());
        onView(withId(R.id.recycler_list_holder)).check(matches(isDisplayed()));
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine5)).check(matches(isDisplayed()));

        // American
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine6)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine6)).check(matches(isDisplayed()));

        // British
        SystemClock.sleep(pauseTime);
        onView(ViewMatchers.withId(R.id.cuisine7)).perform(ViewActions.scrollTo());
        onView(withId(R.id.cuisine7)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine7)).check(matches(isDisplayed()));

        // Spanish
        SystemClock.sleep(pauseTime);
        onView(withId(R.id.cuisine8)).perform(click());
        onView(withText("Please add some more ingredients.")).check(matches(isDisplayed()));
        pressBack();
        SystemClock.sleep(pauseTime);
        pressBack();
        onView(ViewMatchers.withId(R.id.cuisine8)).check(matches(isDisplayed()));

        pressBack();

        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("salt"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());
        SystemClock.sleep(pauseTime);
        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("shredded cheese"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());
        SystemClock.sleep(pauseTime);
        onView(ViewMatchers.withId(R.id.ingredients_Input)).perform(typeText("milk"));
        onView(ViewMatchers.withId(R.id.ingredients_Enter_Button)).perform(click());

        SystemClock.sleep(pauseTime);
        onView(ViewMatchers.withId(R.id.next_button)).perform(click());

        // clicking All cuisines to see
        onView(ViewMatchers.withId(R.id.cuisine1)).perform(click());

        // verifying that recipes are shown and accesses the database no problem
        /**
         * Should show a recycled list of:
         * Scrambled eggs~ 100% Match
         * Scrambled eggs with cheese~ 100% Match
         * Fried egg~ Almost Match
         */
        onView(ViewMatchers.withId(R.id.recycler_list_holder)).check(matches(isDisplayed()));
        onView(ViewMatchers.withText("Scrambled eggs~ 100% Match")).check(matches(isDisplayed()));
        onView(ViewMatchers.withText("Scrambled eggs with cheese~ 100% Match")).check(matches(isDisplayed()));
        onView(ViewMatchers.withText("Fried egg~ Almost Match")).check(matches(isDisplayed()));


        // now click on a recipe: it should show the procedures
        onView(ViewMatchers.withText("Scrambled eggs~ 100% Match")).perform(click());
        onView(ViewMatchers.withId(R.id.Title_text)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.description_title)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.Title_cuisine)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.description_cuisine)).check(matches(isDisplayed()));

        onView(ViewMatchers.withId(R.id.just_TEXT)).perform(ViewActions.scrollTo());
        onView(ViewMatchers.withId(R.id.just_TEXT)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.description_ingredientList)).check(matches(isDisplayed()));

        onView(ViewMatchers.withId(R.id.Title_discription)).perform(ViewActions.scrollTo());
        onView(ViewMatchers.withId(R.id.Title_discription)).check(matches(isDisplayed()));

        onView(ViewMatchers.withId(R.id.description)).perform(ViewActions.scrollTo());
        onView(ViewMatchers.withId(R.id.description)).check(matches(isDisplayed()));

        SystemClock.sleep(pauseTime);

        // now checking if the share recipe button shows
        onView(ViewMatchers.withId(R.id.share_reciepe)).perform(click());
    }
}
