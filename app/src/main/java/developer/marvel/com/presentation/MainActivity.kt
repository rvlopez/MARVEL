package developer.marvel.com.presentation

import android.os.Bundle
import dagger.android.DaggerActivity
import developer.marvel.com.R

class MainActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
