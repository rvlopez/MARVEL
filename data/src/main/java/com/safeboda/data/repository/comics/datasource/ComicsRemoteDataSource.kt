package com.safeboda.data.repository.comics.datasource

import com.safeboda.data.repository.comics.ComicsApi
import com.safeboda.domain.entity.ComicDataWrapper
import io.reactivex.Single
import javax.inject.Inject

class ComicsRemoteDataSource @Inject constructor(
    private val comicsApi: ComicsApi
) {

    fun getComics(): Single<ComicDataWrapper.ComicData> =
        comicsApi.getComics().map { it.toDomain().comicDataResponse }

}