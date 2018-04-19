package search.example.com.features.main

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response
import search.example.com.data.api.GithubApi
import search.example.com.data.models.RepoItem
import search.example.com.data.models.SearchRepositoryResponse
import search.example.com.utils.schedulers.TrampolineSchedulerProvider

/**
 * Unit tests for [MainPresenter]
 */

class MainPresenterTest {

    @Mock private lateinit var view: MainMVP.View

    @Mock private lateinit var service: GithubApi

    private val schedulerProvider = TrampolineSchedulerProvider()

    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = MainPresenter(view, service, schedulerProvider)
    }

    @Test
    fun onQuery_shouldShowData() {
        // Given
        val response = response()
        `when`(service.search(anyString()))
                .thenReturn(Observable.just(response))

        // When
        presenter.onQuery("someString")

        // Then
        verify(view).showProgressBar()
        verify(view).hideProgressBar()
        verify(view).showData(response.body()?.items)
    }

    @Test
    fun onQuery_shouldThrow() {
        // Given
        `when`(service.search(anyString()))
                .thenReturn(Observable.error(Throwable()))

        // When
        presenter.onQuery("someString")

        // Then
        verify(view).showProgressBar()
        verify(view).hideProgressBar()
    }

    private fun response(): Response<SearchRepositoryResponse> {
        return Response.success(SearchRepositoryResponse(10, true, repos()))
    }

    private fun repos(): List<RepoItem> {
        val item1 = mock(RepoItem::class.java)
        val item2 = mock(RepoItem::class.java)
        val item3 = mock(RepoItem::class.java)

        return listOf(item1, item2, item3)
    }
}