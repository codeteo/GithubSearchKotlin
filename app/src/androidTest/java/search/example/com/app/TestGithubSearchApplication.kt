package search.example.com.app

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import search.example.com.app.di.TestApplicationComponent
import javax.inject.Inject

/**
 * Test application class
 */

class TestGithubSearchApplication: DaggerApplication() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var testAppComponent: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    fun initInjection() {
        var component: DaggerTestApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
