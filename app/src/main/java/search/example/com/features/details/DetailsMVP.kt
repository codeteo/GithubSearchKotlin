package search.example.com.features.details

import search.example.com.features.details.models.UserProfileViewModel

/**
 * Contract between View and Presenter for [DetailsActivity]
 */

interface DetailsMVP {

    interface View {

        fun showData(profile: UserProfileViewModel)

        fun showProgressBar()

        fun hideProgressBar()
    }

    interface Presenter {

        fun onLoadData(username: String)

    }

}