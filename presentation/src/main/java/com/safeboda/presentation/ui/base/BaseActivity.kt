package com.safeboda.presentation.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.support.DaggerAppCompatActivity
import developer.marvel.com.R

abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract var childFragment: BaseFragment?

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        childFragment?.let { pushChildStack(it) }
    }

    private fun pushChildStack(fragment: BaseFragment) {
        if (isFinishing.not()) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.parentContainer, fragment, fragment::class.java.simpleName)
                .addToBackStack(fragment::class.java.simpleName)
                .commit()
        }
    }

}