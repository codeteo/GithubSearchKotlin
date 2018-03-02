package search.example.com.features.main

import search.example.com.data.api.GithubApi
import search.example.com.utils.schedulers.BaseSchedulerProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Presenter for [MainActivity]. Handles UI actions.
 */

class MainPresenter
    @Inject constructor(
            val view: MainMVP.View,
            val service: GithubApi,
            val schedulerProvider: BaseSchedulerProvider
    ) : MainMVP.Presenter {

    override fun onQuery(query: String) {
        Timber.i("Execute Query")
        service.search(query)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread())
                .subscribe({
                    response ->
                    run {
                        if (response.isSuccessful) {
                            val body = response.body()
                            view.showData(body?.items)
                        }
                    }
                }, {
                    t: Throwable? ->
                    Timber.i("throw: %s", t?.stackTrace)
                })
    }

    override fun onLoadData() {
        Timber.i("Load data")
    }

}