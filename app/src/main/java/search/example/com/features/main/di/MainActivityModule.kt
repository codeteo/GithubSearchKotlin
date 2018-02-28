package search.example.com.features.main.di

import dagger.Binds
import dagger.Module
import search.example.com.di.ActivityScope
import search.example.com.features.main.MainActivity
import search.example.com.features.main.MainMVP
import search.example.com.features.main.MainPresenter


/**
 * Dagger module for [MainActivity].
 */

@Module
abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract fun providesMainPresenter(presenter: MainPresenter): MainMVP.Presenter

    @ActivityScope
    @Binds
    abstract fun providesMainActivity(activity: MainActivity): MainMVP.View


}