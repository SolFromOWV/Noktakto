package cstjean.mobile.noktakto;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.is;

import android.os.RemoteException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests instumentés.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    /**
     * Rule pour l'activité.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testVictoireJoueurUn() {
        onView(withTagValue(is(0))).perform(click());
        onView(withTagValue(is(1))).perform(click());
        onView(withTagValue(is(3))).perform(click());
        onView(withTagValue(is(2))).perform(click());

        onView(withId(R.id.text_perdant)).check(matches(withText("Le joueur perdant est Joueur 2")));
    }

    @Test
    public void testVictoireJoueurDeux() {
        onView(withTagValue(is(0))).perform(click());
        onView(withTagValue(is(1))).perform(click());
        onView(withTagValue(is(2))).perform(click());

        onView(withId(R.id.text_perdant)).check(matches(withText("Le joueur perdant est Joueur 1")));
    }

    @Test
    public void testRotationVictoireJoueurUn() throws RemoteException {
        UiDevice device = UiDevice.getInstance(getInstrumentation());

        onView(withTagValue(is(0))).perform(click());
        onView(withTagValue(is(1))).perform(click());
        device.setOrientationLeft();
        onView(withTagValue(is(3))).perform(click());
        onView(withTagValue(is(2))).perform(click());

        onView(withId(R.id.text_perdant)).check(matches(withText("Le joueur perdant est Joueur 2")));
    }
}
