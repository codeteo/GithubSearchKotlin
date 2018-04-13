package search.example.com.features.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R
import javax.inject.Inject

/**
 * Details screen displaying details for a selected user.
 */

const val PARAM_USERNAME = "username"

class DetailsActivity : DaggerAppCompatActivity(), DetailsMVP.View {

    @BindView(R.id.main_toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.pb_progressbar) lateinit var progressBar: ProgressBar

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

    override fun showData() {
        TODO("not implemented")
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

}