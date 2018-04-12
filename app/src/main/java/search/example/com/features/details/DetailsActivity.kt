package search.example.com.features.details

import android.os.Bundle
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R
import javax.inject.Inject

/**
 * Details screen displaying details for a selected user.
 */

class DetailsActivity : DaggerAppCompatActivity(), DetailsMVP.View {

    @BindView(R.id.main_toolbar) lateinit var toolbar: Toolbar

    @Inject lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "DETAILS"

        presenter.onLoadData()
    }

    override fun showData() {
        TODO("not implemented")
    }

    override fun showProgressBar() {
        TODO("not implemented")
    }

    override fun hideProgressBar() {
        TODO("not implemented")
    }

}