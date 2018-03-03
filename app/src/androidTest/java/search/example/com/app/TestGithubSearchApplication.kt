package search.example.com.app

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import search.example.com.app.di.TestApplicationComponent
import javax.inject.Inject

/**
 * Test application class
 */

class TestGithubSearchApplication: DaggerApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var testAppComponent: TestApplicationComponent

//    var component: DaggerTestApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    fun initInjection() {
        DaggerTestApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
