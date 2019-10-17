package com.safeboda.domain.usecase

import com.safeboda.domain.base.SingleUseCase
import com.safeboda.domain.entity.ComicDataWrapper
import com.safeboda.domain.repository.ComicsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepository: ComicsRepository
) : SingleUseCase<ComicDataWrapper.ComicData, Unit> {

    override fun invoke(params: Unit): Single<ComicDataWrapper.ComicData> =
        comicsRepository.getComics()

}