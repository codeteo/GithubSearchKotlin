package search.example.com.app.di

import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import search.example.com.data.api.GithubApi
import javax.inject.Singleton

/**
 * Provides mock dependencies.
 */

@Module
class MockModule {

    @Provides
    @Singleton
    fun providesGithubApi(): GithubApi{
        return Mockito.mock(GithubApi::class.java)
    }

}