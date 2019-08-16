package developer.marvel.com.domain.usecase

import developer.marvel.com.domain.base.SingleUseCase
import developer.marvel.com.domain.entity.ComicDataWrapper
import developer.marvel.com.domain.repository.ComicsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(
    private val comicsRepository: ComicsRepository
) : SingleUseCase<ComicDataWrapper, Unit> {

    override fun invoke(params: Unit): Single<ComicDataWrapper> =
        comicsRepository.getComics()

}