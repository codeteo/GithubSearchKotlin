package search.example.com.features.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R
import search.example.com.features.details.models.UserProfileViewModel
import javax.inject.Inject

/**
 * Details screen displaying details for a selected user.
 */

const val PARAM_USERNAME = "username"

class DetailsActivity : DaggerAppCompatActivity(), DetailsMVP.View {

    @BindView(R.id.main_toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.pb_progressbar) lateinit var progressBar: ProgressBar
    @BindView(R.id.iv_user_profile_avatar) lateinit var ivAvatar: ImageView
    @BindView(R.id.tv_user_profile_name) lateinit var tvName: TextView
    @BindView(R.id.tv_user_profile_company) lateinit var tvCompany: TextView
    @BindView(R.id.tv_user_profile_bio) lateinit var tvBio: TextView
    @BindView(R.id.tv_user_profile_following) lateinit var tvFollowing: TextView
    @BindView(R.id.tv_user_profile_followers) lateinit var tvFollowers: TextView

    @Inject lateinit var presenter: DetailsPresenter

    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        ButterKnife.bind(this)

        initViews()

        username = intent.getStringExtra(PARAM_USERNAME)

        presenter.onLoadData(username)
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "DETAILS"
    }

    override fun showData(profile: UserProfileViewModel) {
        Picasso.with(this)
                .load(profile.avatarUrl)
                .centerCrop()
                .fit()
                .into(ivAvatar)

        tvName.text = profile.name
        tvCompany.text = profile.company
        tvBio.text = profile.bio
        tvFollowing.text = profile.following.toString()
        tvFollowers.text = profile.followers.toString()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

}