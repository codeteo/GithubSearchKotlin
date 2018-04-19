package search.example.com.features.details

import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response
import search.example.com.data.api.GithubApi
import search.example.com.data.models.Repo
import search.example.com.data.models.User
import search.example.com.features.details.models.UserProfileViewModel
import search.example.com.utils.schedulers.TrampolineSchedulerProvider

/**
 * Unit tests for [DetailsPresenter].
 */

class DetailsPresenterTest {

    @Mock private lateinit var view: DetailsMVP.View

    @Mock private lateinit var service: GithubApi

    private val schedulerProvider = TrampolineSchedulerProvider()

    private lateinit var presenter: DetailsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = DetailsPresenter(view, service, schedulerProvider)
    }

    @Test
    fun onLoadData() {
        // Given
        val userResponse = userResponse()
        `when`(service.getUser(anyString()))
                .thenReturn(Single.just(userResponse))
        `when`(service.getUserRepos(anyString(), anyInt()))
                .thenReturn(Single.just(reposResponse()))

        // When
        presenter.onLoadData("someString")

        // Then
        verify(view).showProgressBar()
        verify(view).hideProgressBar()
        verify(view).showData(any(UserProfileViewModel::class.java))
    }

    private fun userResponse(): Response<User> {
        return Response.success(mock(User::class.java))
    }

    private fun reposResponse(): Response<List<Repo>> {
        return Response.success(listOf(mock(Repo::class.java), mock(Repo::class.java), mock(Repo::class.java)))
    }

}