package search.example.com.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import search.example.com.data.api.GithubApi
import search.example.com.utils.BaseUrlInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton




/**
 * Dagger module building dependencies with Application scope.
 */

@Singleton
@Module
class NetworkModule {

    private val CONNECTION_TIMEOUT = 15

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder()
                .create()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(baseUrlInterceptor: BaseUrlInterceptor): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.retryOnConnectionFailure(true)
        client.addInterceptor(interceptor)
        client.addInterceptor(baseUrlInterceptor)
        client.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)

        return client.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesGithubApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }
}