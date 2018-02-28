package search.example.com.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import search.example.com.di.ActivityScope
import search.example.com.features.main.MainActivity
import search.example.com.features.main.di.MainActivityModule


@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindsMainActivity(): MainActivity

}