package com.safeboda.data.repository.comics

import com.safeboda.data.repository.comics.datasource.ComicsLocalDataSource
import com.safeboda.data.repository.comics.datasource.ComicsRemoteDataSource
import com.safeboda.domain.entity.ComicDataWrapper
import com.safeboda.domain.repository.ComicsRepository
import io.reactivex.Single
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val comicsRemoteDataSource: ComicsRemoteDataSource,
    private val comicsLocalDataSource: ComicsLocalDataSource
) : ComicsRepository {

    override fun getComics(): Single<ComicDataWrapper.ComicData> =
        Single.concat(
            comicsLocalDataSource.getComics(),
            comicsRemoteDataSource.getComics()
                .doOnSuccess(comicsLocalDataSource::saveComics)
        ).filter { it.comics.isNotEmpty() }.firstOrError()

}