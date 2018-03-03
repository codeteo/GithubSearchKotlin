package search.example.com.app.di

import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import search.example.com.data.api.GithubApi
import search.example.com.features.main.MainMVP
import javax.inject.Singleton

/**
 * Provides mock dependencies.
 */

@Module
class MockModule {

    @Provides
    @Singleton
    fun providesMockGithubApi(): GithubApi{
        return mock(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMockView(): MainMVP.View{
        return mock(MainMVP.View::class.java)
    }

}