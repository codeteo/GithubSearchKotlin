package search.example.com.features.main.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repo.view.*
import search.example.com.R
import search.example.com.data.models.RepoItem
import search.example.com.utils.CircleTransformPicasso

/**
 * View holder for items in [SearchAdapter]
 */

class SearchViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(repoItem: RepoItem, listener: (RepoItem) -> Unit) {
        with(repoItem) {
            itemView.tv_item_name.text = owner.login
            Picasso.with(itemView.context)
                    .load(owner.avatarUrl)
                    .transform(CircleTransformPicasso())
                    .placeholder(ContextCompat.getDrawable(itemView.context, R.drawable.ic_placeholder))
                    .fit()
                    .centerCrop()
                    .into(itemView.iv_item_avatar)
        }
        with(itemView) {
            setOnClickListener{ listener(repoItem) }
        }
    }

}