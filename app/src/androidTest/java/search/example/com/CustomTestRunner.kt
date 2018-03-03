package search.example.com

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import search.example.com.app.TestGithubSearchApplication

/**
 * Custom runner for our espresso tests.
 * Idea is from Artem's [post](https://artemzin.com/blog/how-to-mock-dependencies-in-unit-integration-and-functional-tests-dagger-robolectric-instrumentation/)
 */

class CustomTestRunner : AndroidJUnitRunner() {
    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestGithubSearchApplication::class.java.getName(), context)
    }
}