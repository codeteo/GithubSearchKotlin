package search.example.com.app.screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.AutoCompleteTextView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import retrofit2.Response
import search.example.com.R
import search.example.com.app.TestGithubSearchApplication
import search.example.com.data.api.GithubApi
import search.example.com.data.models.Owner
import search.example.com.data.models.RepoItem
import search.example.com.data.models.SearchRepositoryResponse
import search.example.com.features.main.MainActivity
import javax.inject.Inject


/**
 * Functional tests for MainActivity.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Inject
    lateinit var service: GithubApi

    @Before
    fun setUp() {
        val testApp = activityTestRule.activity.applicationContext as TestGithubSearchApplication
        testApp.testAppComponent.inject(this)
    }

    @Test
    fun showsData() {
        `when`(service.search("retrofit"))
                .thenReturn(Observable.just(getResponse()))

        onView(withId(R.id.menu_main_search))
                .perform(click())

        onView(isAssignableFrom(AutoCompleteTextView::class.java))
                .perform(typeText("retrofit"))

        onView(isAssignableFrom(AutoCompleteTextView::class.java))
                .perform(ViewActions.pressImeActionButton())

        onView(withText("Jake Wharton"))
                .check(matches(isDisplayed()))

    }

    private fun getResponse(): Response<SearchRepositoryResponse> {
        val item1 = RepoItem(32.5, Owner(null, "Jake Wharton", null, null), anyString())
        val item2 = RepoItem(30.5, Owner(null, "Ozzy Osborne", null, null), anyString())
        val item3 = RepoItem(28.5, Owner(null, "Kirk Hammett", null, null), anyString())

        val items: List<RepoItem> = listOf(
                item1,
                item2,
                item3
        )

        return Response.success(
                SearchRepositoryResponse(10, false, items))
    }

}