package Fragment_Meniu

import FragmentMeniu.FragmentMeniu
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ProiectSI.Login_Activity
import com.ProiectSI.R
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class FragmentMeniuTest {

    @Before
    fun setUp() {
        Intents.init()
        launchFragmentInContainer<FragmentMeniu>(themeResId = R.style.Theme_MyApplication2)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    // Test daca TabLayout-ul este vizibil
    @Test
    fun testTabLayoutIsDisplayed() {
        onView(withId(R.id.tabLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.tabHolder)).check(matches(isDisplayed()))
    }

    // Test daca ViewPager-ul este vizibil
    @Test
    fun testViewPagerIsDisplayed() {
        onView(withId(R.id.tabHolder)).check(matches(isDisplayed()))
    }

    // Test daca taburile au numele corecte
    @Test
    fun testFirstTabText() {
        onView(allOf(withText("Aperitive"), isDisplayed())).check(matches(isDisplayed()))
        onView(allOf(withText("Fel Principal"), isDisplayed())).check(matches(isDisplayed()))
        onView(allOf(withText("Bauturi spirtoase"), isDisplayed())).check(matches(isDisplayed()))
        onView(allOf(withText("Bauturi nespirtoase"), isDisplayed())).check(matches(isDisplayed()))
    }

    // Test daca butonul de login si cautare este vizibil
    @Test
    fun testLoginButtonIsDisplayed() {
        onView(withId(R.id.login_button2)).check(matches(isDisplayed()))
        onView(withId(R.id.search_button)).check(matches(isDisplayed()))
    }


    // Test dacă butonul de login pornește Login_Activity
    @Test
    fun testLoginButtonStartsActivity() {
        onView(withId(R.id.login_button2)).perform(click())
        Intents.intended(hasComponent(Login_Activity::class.java.name))
    }

}