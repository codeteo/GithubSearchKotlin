package search.example.com.features.main

import search.example.com.data.models.RepoItem

/**
 * Contract between View and Presenter for [MainActivity]
 */

interface MainMVP {

    interface View {

        fun showData(data: List<RepoItem>?)

        fun showProgressBar()

        fun hideProgressBar()
    }

    interface Presenter {

        fun onLoadData()

        fun onQuery(query: String)

    }

}