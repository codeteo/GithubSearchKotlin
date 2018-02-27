package search.example.com.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import search.example.com.GithubSearchApplication
import javax.inject.Singleton

/**
 * Dagger module building dependencies with Application scope.
 */

@Singleton
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesContext(app: GithubSearchApplication): Context = app.applicationContext


}
