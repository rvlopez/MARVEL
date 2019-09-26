package developer.marvel.com.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Lazy
import dagger.android.support.DaggerFragment
import developer.marvel.com.R
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: Lazy<ViewModelProvider.Factory>

    @set:LayoutRes
    abstract var fragmentLayout: Int

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(fragmentLayout, container, false)

    protected fun pushStack(fragment: Fragment) {
        activity?.let {
            if (it.isFinishing.not()) {
                fragmentManager
                    ?.beginTransaction()
                    ?.setCustomAnimations(
                        R.anim.animation_enter,
                        R.anim.animation_leave,
                        R.anim.animation_enter,
                        R.anim.animation_leave
                    )
                    ?.addToBackStack(null)
                    ?.add(R.id.parentContainer, fragment)
                    ?.commit()
            }
        }
    }

    override fun onDestroy() {
        dispose()
        super.onDestroy()
    }

    private fun dispose() {
        compositeDisposable.clear()
    }

}