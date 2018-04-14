package search.example.com.features.details.di

import dagger.Binds
import dagger.Module
import search.example.com.di.ActivityScope
import search.example.com.features.details.DetailsActivity
import search.example.com.features.details.DetailsMVP
import search.example.com.features.details.DetailsPresenter

/**
 * Dagger module for [DetailsActivity].
 */

@Module
abstract class DetailsActivityModule {

    @ActivityScope
    @Binds
    abstract fun providesDetailsPresenter(presenter: DetailsPresenter): DetailsMVP.Presenter

    @ActivityScope
    @Binds
    abstract fun providesDetailsActivity(activity: DetailsActivity): DetailsMVP.View


}
