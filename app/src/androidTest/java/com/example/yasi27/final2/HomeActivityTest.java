package com.example.yasi27.final2;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.contrib.PickerActions.setTime;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsAnything.anything;

public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule =
            new ActivityTestRule<>(HomeActivity.class);


    @Test
    public void ArticleActivity() {

        Intents.init();
        onView(withId(R.id.notes)).perform(click());
        intended(hasComponent(ArticlesActivity.class.getName()));
        Intents.release();
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.listView)) // Specify the explicit id of the ListView
                .atPosition(9) // Explicitly specify the adapter item to use
                .perform(click());
//        onView(withId(R.id.listView)).perform(scrollTo(), click());
    }

    @Test
    public void HeartRateActivity() {

        Intents.init();
        onView(withId(R.id.weight)).perform(click());
        intended(hasComponent(HeartRateActivity.class.getName()));
        Intents.release();

    }
    @Test
    public void WeightActivity() {

        Intents.init();
        onView(withId(R.id.myweight)).perform(click());
        intended(hasComponent(WeightActivity.class.getName()));
        Intents.release();
        onView(withId(R.id.preweight)).perform(typeText("54"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.currentweight)).perform(typeText("68"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.cancel)).perform(click());
        onView(withId(R.id.preweight)).perform(typeText("57"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.currentweight)).perform(typeText("68"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.save)).perform(click());

    }
    @Test
    public void AskDoctortActivity() {

//        int year = 2017, month = 10, day = 20;

        Intents.init();
        onView(withId(R.id.askmydoc)).perform(click());
        intended(hasComponent(AppointmentActivity.class.getName()));
        Intents.release();
//        onView(withId(R.id.edittime)).perform(click());
//        onView(isAssignableFrom(TimePicker.class)).perform(setTime(12, 36));
        onView(withId(R.id.edittime)).perform(typeText("12:30"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editdate)).perform(typeText("27.02" + ""), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.reminder)).perform(click());

    }

    private ViewAction setTime(int i, int i1) {
        return null;
    }

    private void intended(Matcher<Intent> intentMatcher) {
    }

}
