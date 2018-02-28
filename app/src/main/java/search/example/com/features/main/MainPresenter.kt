package search.example.com.features.main

import timber.log.Timber
import javax.inject.Inject

/**
 * Presenter for [MainActivity]. Handles UI actions.
 */

class MainPresenter @Inject constructor(val view: MainMVP.View) : MainMVP.Presenter {

    override fun onLoadData() {
        Timber.i("Load data")
    }

}