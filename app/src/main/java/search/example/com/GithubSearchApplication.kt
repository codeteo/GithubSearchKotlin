package search.example.com

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Main entry point of the app.
 */

class GithubSearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}