package search.example.com.features.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainMVP.View {

    @BindView(R.id.main_toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.rv_main_recyclerview)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.pb_main_progress_bar)
    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var presenter: MainMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "TITLE"

        presenter.onLoadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun showData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
