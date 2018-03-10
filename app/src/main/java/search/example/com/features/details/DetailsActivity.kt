package search.example.com.features.details

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import search.example.com.R

/**
 * Details screen displaying details for a selected user.
 */

class DetailsActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}