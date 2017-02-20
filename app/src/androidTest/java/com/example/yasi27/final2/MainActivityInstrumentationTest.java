package com.example.yasi27.final2;


import android.content.Intent;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.widget.DatePicker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


// Tests for MainActivity
public class MainActivityInstrumentationTest {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @Rule
    public ActivityTestRule<NewUserActivity> activityTestRule =
            new ActivityTestRule<>(NewUserActivity.class);
    @Test
    public void validateEditText() {
        onView(withId(R.id.editText)).perform(typeText("yasmin"), ViewActions.closeSoftKeyboard());

//        onView(withId(R.id.due)).perform(click());
//        onView(isAssignableFrom(DatePicker.class)).perform(setDate(2017, 02
//                , 17));
//        onView(withText("OK")).perform(click());
//        onView(withId(R.id.button)).perform(click());
//        onView(withId(R.id.button)).check(matches(not(isEnabled())));

            Intents.init();
            onView(withId(R.id.button)).perform(click());
            intended(hasComponent(HomeActivity.class.getName()));
            Intents.release();


        }


    private void intended(Matcher<Intent> intentMatcher) {
    }
}