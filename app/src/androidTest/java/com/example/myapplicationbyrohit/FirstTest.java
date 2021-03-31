package com.example.myapplicationbyrohit;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)




public class FirstTest{

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);
   @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }

    @Test
    public void testCase1() {

       //TestCase 1-a
        String message = "Hello There";
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(message));
        onView(withId(R.id.button2)).perform(click());
        //Starting ClientActivity
        //Receiving an intent
        intended(toPackage("com.example.myapplicationbyrohit"));
        //Checking received message
        intended(hasExtra(MainActivity.EXTRA_MESSAGE,message));

        //TestCase 1-b

        //Pressing the back button

        onView(withContentDescription("Navigate up")).perform(click());
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText(message)));

        //TestCase 1-c

        onView(withId(R.id.button)).perform(click());
        //waiting for the user to speak
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = "hello";
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText(text)));
    }

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}

