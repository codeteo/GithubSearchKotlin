package search.example.com.features.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import search.example.com.R
import search.example.com.data.models.RepoItem
import search.example.com.features.main.adapter.SearchAdapter
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainMVP.View {

    @BindView(R.id.main_toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.rv_main_recyclerview)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.pb_main_progress_bar)
    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "SEARCH"

        presenter.onLoadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu?.findItem(R.id.menu_main_search)
        val searchView = menuItem?.actionView as android.support.v7.widget.SearchView

        searchView.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                if (!searchView.isIconified) {
                    searchView.isIconified = true
                }
                presenter.onQuery(query)
                return false
            }

            override fun onQueryTextChange(string: String): Boolean = false
        })

        return true
    }

    override fun showData(data: List<RepoItem>?) {
        if (data != null) {
            rv_main_recyclerview.adapter = SearchAdapter(data)
        }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

}
