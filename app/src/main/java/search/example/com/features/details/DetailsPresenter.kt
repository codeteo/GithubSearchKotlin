package search.example.com.features.details

import io.reactivex.functions.BiConsumer
import io.reactivex.functions.Consumer
import search.example.com.data.api.GithubApi
import search.example.com.features.details.models.UserProfileViewModel
import search.example.com.utils.schedulers.BaseSchedulerProvider
import timber.log.Timber
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

        service.getUserRepos(username, 0)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe(BiConsumer { t1, t2 ->
                    if (t1.isSuccessful) {
                        val body = t1.body()
                        Timber.i("t1 == %d", body?.size)
                    }
                })
    }

}