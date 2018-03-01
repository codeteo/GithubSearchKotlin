package search.example.com.features.main

/**
 * Contract between View and Presenter for [MainActivity]
 */

interface MainMVP {

    interface View {

        fun showData()

    }

    interface Presenter {

        fun onLoadData()

        fun onQuery(query: String)

    }

}