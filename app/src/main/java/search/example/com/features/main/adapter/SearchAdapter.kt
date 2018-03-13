package search.example.com.features.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import search.example.com.R
import search.example.com.data.models.RepoItem

/**
 * Adapter for [MainActivity].
 * Displays search results.
 */

class SearchAdapter(var dataset: List<RepoItem>, val listener: (RepoItem) -> Unit):
    RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindItem(dataset[position], listener)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun setData(data: List<RepoItem>) {
        dataset = data
    }

}