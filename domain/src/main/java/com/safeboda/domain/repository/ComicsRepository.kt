package com.safeboda.domain.repository

import com.safeboda.domain.entity.ComicDataWrapper
import io.reactivex.Single

interface ComicsRepository {

    fun getComics(): Single<ComicDataWrapper.ComicData>

}