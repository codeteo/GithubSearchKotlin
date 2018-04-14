package search.example.com.features.details

import io.reactivex.functions.Consumer
import search.example.com.data.api.GithubApi
import search.example.com.features.details.models.UserProfileViewModel
import search.example.com.utils.schedulers.BaseSchedulerProvider
import javax.inject.Inject

class DetailsPresenter
    @Inject constructor(
            val view: DetailsMVP.View?,
            val service: GithubApi,
            val schedulerProvider: BaseSchedulerProvider
    ) : DetailsMVP.Presenter {

    override fun onLoadData(username: String) {
        view?.showProgressBar()

        service.getUser(username)
                .map {
                    if (it.isSuccessful) {
                        val body = it.body()
                        UserProfileViewModel(body?.avatarUrl, body?.name ?: "", body?.company?: "",
                                body?.bio ?: "", body?.following?.toInt() ?: 0, body?.followers?.toInt()?: 0)
                    } else {
                        UserProfileViewModel(null, "", "", "", 0, 0)
                    }
                }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe(Consumer {
                    view?.hideProgressBar()
                    view?.showData(it)
                })
    }

}