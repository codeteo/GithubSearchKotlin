package search.example.com.features.details

/**
 * Contract between View and Presenter for [DetailsActivity]
 */

interface DetailsMVP {

    interface View {

        fun showData()

        fun showProgressBar()

        fun hideProgressBar()
    }

    interface Presenter {

        fun onLoadData(ownerId: String)

    }

}