package search.example.com.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import search.example.com.app.di.DaggerTestApplicationComponent
import search.example.com.app.di.TestApplicationComponent
import javax.inject.Inject

/**
 * Test application class
 */

class TestGithubSearchApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var testAppComponent: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()

        testAppComponent = DaggerTestApplicationComponent.builder()
                .application(this)
                .build()

        testAppComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}
