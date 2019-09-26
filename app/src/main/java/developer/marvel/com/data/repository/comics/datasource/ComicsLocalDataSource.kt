package developer.marvel.com.data.repository.comics.datasource

import developer.marvel.com.data.base.BaseLocalDataSource
import developer.marvel.com.data.base.SharedPreferencesAssistant
import developer.marvel.com.data.base.SharedPreferencesKeys.COMICS_PREF
import developer.marvel.com.data.base.SharedPreferencesKeys.COMIC_LIST_KEY
import developer.marvel.com.domain.entity.ComicDataWrapper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class ComicsLocalDataSource @Inject constructor(
    @Named(COMICS_PREF)
    private val assistant: SharedPreferencesAssistant
) : BaseLocalDataSource() {

    fun saveComics(comicDataWrapper: ComicDataWrapper.ComicData) {
        assistant.saveString(COMIC_LIST_KEY, comicDataWrapper.toJson())
    }

    fun getComics(): Single<ComicDataWrapper.ComicData> =
        assistant.getString(COMIC_LIST_KEY).fromJson()

}