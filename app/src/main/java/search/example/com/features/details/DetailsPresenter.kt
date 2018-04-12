package search.example.com.features.details

import timber.log.Timber
import javax.inject.Inject

class DetailsPresenter
    @Inject constructor() : DetailsMVP.Presenter {

    override fun onLoadData() {
        Timber.i("onLoadData")
    }

}