package search.example.com.app.screens

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import search.example.com.app.TestGithubSearchApplication
import search.example.com.features.main.MainActivity

/**
 * Functional tests for MainActivity.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Before
    fun setUp() {
        val testApp = activityTestRule.activity.applicationContext as TestGithubSearchApplication
        testApp.testAppComponent.inject(this)
    }

}