package search.example.com.features.details

import search.example.com.data.api.GithubApi
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
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe({
                    response ->
                        run {
                            Timber.i("SOME RESPONSE")
                            view?.hideProgressBar()
                        }
                }, {
                    t: Throwable? ->
                        run {
                            view?.hideProgressBar()
                            Timber.i(t, "Throws")
                        }
                })
    }

}