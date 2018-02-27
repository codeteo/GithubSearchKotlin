package search.example.com

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import search.example.com.di.component.DaggerApplicationComponent
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject

/**
 * Main entry point of the app.
 */

class GithubSearchApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initInjection()
    }

    private fun initInjection() {
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}