package com.safeboda.data.repository.comics.datasource

import com.safeboda.data.base.BaseLocalDataSource
import com.safeboda.data.base.SharedPreferencesAssistant
import com.safeboda.data.base.SharedPreferencesKeys.COMICS_PREF
import com.safeboda.data.base.SharedPreferencesKeys.COMIC_LIST_KEY
import com.safeboda.domain.entity.ComicDataWrapper
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