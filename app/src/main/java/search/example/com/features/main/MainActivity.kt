package search.example.com.features.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainMVP.View {

    @Inject
    lateinit var presenter: MainMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onLoadData()
    }

    override fun showData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
