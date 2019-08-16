package developer.marvel.com.presentation.ui.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private var mutableLoading: MutableLiveData<Boolean> = MutableLiveData()
    val ldLoading: LiveData<Boolean> = mutableLoading

    protected val compositeDisposable = CompositeDisposable()

    protected fun Disposable.add() {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun loading(visible: Boolean) {
        mutableLoading.value = visible
    }

}