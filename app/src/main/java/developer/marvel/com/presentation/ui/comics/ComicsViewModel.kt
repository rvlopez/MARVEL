package developer.marvel.com.presentation.ui.comics

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import developer.marvel.com.domain.entity.ComicDataWrapper
import developer.marvel.com.domain.usecase.GetComicsUseCase
import developer.marvel.com.presentation.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase
) : BaseViewModel() {

    private val _ldComics = MutableLiveData<ComicDataWrapper>()
    val ldComics: LiveData<ComicDataWrapper> = _ldComics

    fun getComics() =
        getComicsUseCase(Unit)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loading(true) }
            .doAfterTerminate { loading(false) }
            .subscribe({ comics ->
                _ldComics.value = comics
            }, {})
            .add()

}