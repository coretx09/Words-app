package com.example.wordsapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import org.junit.runner.RunWith

// exécuteur de test
@RunWith(AndroidJUnit4::class)
class NavigationTests {

   // Fonction de test
   fun navigate_to_words_nav_component() {
       // Instance test navController
       val navController = TestNavHostController(
           ApplicationProvider.getApplicationContext()
       )

       // launch fragment et le theme a utiliser
       val letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId =
       R.style.Theme_Words)

       // navGraph a utiliser
       letterListScenario.onFragment { fragment ->

           navController.setGraph(R.navigation.nav_graph)

           Navigation.setViewNavController(fragment.requireView(), navController)
       }

       // Déclenchez maintenant l'événement qui invite à la navigation.
       onView(withId(R.id.recycler_view))
           .perform(
               RecyclerViewActions
               .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
   }
}