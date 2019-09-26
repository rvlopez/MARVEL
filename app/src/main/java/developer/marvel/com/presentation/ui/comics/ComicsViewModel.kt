package developer.marvel.com.presentation.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import developer.marvel.com.domain.entity.ComicDataWrapper
import developer.marvel.com.domain.usecase.GetComicsUseCase
import developer.marvel.com.presentation.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase
) : BaseViewModel() {

    init {
        getComics()
    }

    private val _ldComics = MutableLiveData<ComicDataWrapper.ComicData>()
    val ldComics: LiveData<ComicDataWrapper.ComicData> = _ldComics

    private fun getComics() =
        getComicsUseCase(Unit)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loading(true) }
            .doAfterTerminate { loading(false) }
            .subscribe({ comics ->
                _ldComics.value = comics
            }, {})
            .addTo(compositeDisposable)

}