package search.example.com.data.api

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import search.example.com.data.models.SearchRepositoryResponse

/**
 * Retrofit interface
 */

interface GithubApi {

    @GET("/search/repositories")
    fun search(@Query("q") query: String): Observable<Response<SearchRepositoryResponse>>

}