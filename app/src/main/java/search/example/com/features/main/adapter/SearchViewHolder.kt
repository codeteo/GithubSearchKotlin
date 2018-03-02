package search.example.com.features.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repo.view.*
import search.example.com.data.models.RepoItem

/**
 * View holder for items in [SearchAdapter]
 */

class SearchViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(repoItem: RepoItem) {
        with(repoItem) {
            itemView.tv_item_name.text = owner.login
            Picasso.with(itemView.context)
                    .load(owner.avatarUrl)
                    .fit()
                    .centerCrop()
                    .into(itemView.iv_item_avatar)
        }
    }

}