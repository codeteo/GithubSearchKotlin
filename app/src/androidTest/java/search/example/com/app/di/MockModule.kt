package search.example.com.app.di

import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import search.example.com.data.api.GithubApi
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

}