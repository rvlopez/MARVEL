package com.safeboda.presentation.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private var mutableLoading: MutableLiveData<Boolean> = MutableLiveData()
    val ldLoading: LiveData<Boolean> = mutableLoading

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun loading(visible: Boolean) {
        mutableLoading.value = visible
    }

}