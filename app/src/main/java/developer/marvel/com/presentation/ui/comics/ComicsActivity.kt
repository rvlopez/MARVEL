package developer.marvel.com.presentation.ui.comics

import android.content.Context
import android.content.Intent
import developer.marvel.com.presentation.ui.base.BaseActivity
import developer.marvel.com.presentation.ui.base.BaseFragment

class ComicsActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, ComicsActivity::class.java)
    }

    override var childFragment: BaseFragment? = ComicsFragment.getFragment()

}