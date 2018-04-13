package search.example.com.data.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import search.example.com.data.models.SearchRepositoryResponse
import search.example.com.data.models.User

/**
 * Retrofit interface
 */

interface GithubApi {

    @GET("/search/repositories")
    fun search(@Query("q") query: String): Observable<Response<SearchRepositoryResponse>>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Single<Response<User>>

}