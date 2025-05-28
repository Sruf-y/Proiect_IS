package Comanda_For_Client


import DataClasses.Comanda
import DataClasses.GlobalVars
import DataClasses.Meniu_Item
import Functii_Utils.Functii
import Start_Activity.AdminActivity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ProiectSI.R
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.coroutines.coroutineContext


class FragmentComandaTest {

//    @get:Rule
//    val activityRule = ActivityScenarioRule(AdminActivity::class.java)

    @Test
    fun testforButtonText() {

        // testeaza daca butonul exista si poate fi apasat

        launchFragmentInContainer<FragmentComanda>()

        onView(withId(R.id.checkOutButton)).perform(click())

    }

    @Test
    fun testForButtonText(){

        // testeaza daca pe buton textul este corect

        launchFragmentInContainer<FragmentComanda>()

        onView(withId(R.id.checkOutButton)).check(matches(withText("Checkout")))
    }

    @Test
    fun testForAdminVisibility_shouldNotInvisible_False(){
        val intent = Intent(ApplicationProvider.getApplicationContext(), AdminActivity::class.java).apply {
            putExtra("arg3", "admin")
        }

        val scenario = ActivityScenario.launch<AdminActivity>(intent)

        onView(withId(R.id.admin_adaugare_item))
            .check(matches(not(isDisplayed()))) // Should be visible with these args
    }

    @Test
    fun testForAdminVisibility_ShouldBeVisible(){
        val intent = Intent(ApplicationProvider.getApplicationContext(), AdminActivity::class.java).apply {
            putExtra("arg3", "admin")
        }

        val scenario = ActivityScenario.launch<AdminActivity>(intent)

        onView(withId(R.id.admin_adaugare_item))
            .check(matches(isDisplayed())) // Should be visible with these args
    }


    @Test
    fun testChitantePrinting(){
        // how to get a "fake" context
        val context = ApplicationProvider.getApplicationContext<Context>()

        val lista = ArrayList(mutableListOf<Meniu_Item>(Meniu_Item()))

        val comandaAux = Comanda(list = lista, listNumberOfs = ArrayList())


        assertThrows<IndexOutOfBoundsException>(IndexOutOfBoundsException::class.java){
            Functii.scoateChitanta(context,comandaAux)
        }



    }

    @Test
    fun testChitantaPrinting_ValoareCorecta(){

        val context = ApplicationProvider.getApplicationContext<Context>()

        val lista = ArrayList(mutableListOf<Meniu_Item>(Meniu_Item()))

        val comandaAux = Comanda(list = lista, listNumberOfs = ArrayList())


        assertThrows<IndexOutOfBoundsException>(IndexOutOfBoundsException::class.java){
            Functii.scoateChitanta(context,Comanda()) // comanda nu are liste de lungimi diferite deci nu v-a da eroare
        }
    }


}