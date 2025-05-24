import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.ProiectSI.R;

import org.junit.runner.RunWith;
import org.junit.Test;

import Comanda_For_Client.FragmentComanda;


@RunWith(AndroidJUnit4.class)
public class JavaTests {

    @Test
    public void testButtonClick_inMyClassicFragment_updatesText() {
        // Launch the fragment in a container.
        // R.style.Theme_YourAppTheme is a placeholder. Use your app's actual theme.
        // Ensure this theme exists. It should be from your app's resources.
        // For example, if your app's R file is com.example.composepls.R
        FragmentScenario.launchInContainer(FragmentComanda.class, null); // Or your actual app theme

        // 1. Check the initial text of the TextView
        Espresso.onView(ViewMatchers.withId(R.id.checkOutButton))
                .check(ViewAssertions.matches(ViewMatchers.withText("Initial Text")));

        // 2. Find the button by its ID and perform a click
        Espresso.onView(ViewMatchers.withId(R.id.checkOutButton))
                .perform(ViewActions.click());

        // 3. Check that the text of the TextView has changed
        Espresso.onView(ViewMatchers.withId(R.id.checkOutButton))
                .check(ViewAssertions.matches(ViewMatchers.withText("Button Clicked!")));
    }
}
