package search.example.com.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import search.example.com.GithubSearchApplication
import search.example.com.data.Constants
import search.example.com.utils.BaseUrlInterceptor
import search.example.com.utils.NetworkUtils
import javax.inject.Singleton


/**
 * Dagger module building dependencies with Application scope.
 */

@Singleton
@Module
class ApplicationModule {

    private val PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL)

    @Provides
    @Singleton
    fun providesContext(app: GithubSearchApplication): Context = app.applicationContext

    @Provides
    @Singleton
    fun providesBaseUrl(): HttpUrl? {
        return PRODUCTION_API_BASE_URL
    }

    @Provides
    @Singleton
    fun providesBaseUrlInterceptor(baseUrl: HttpUrl): BaseUrlInterceptor {
        return BaseUrlInterceptor(baseUrl.toString())
    }

    @Provides
    @Singleton
    fun providesNetworkUtils(context: Context): NetworkUtils {
        return NetworkUtils(context)
    }

}
