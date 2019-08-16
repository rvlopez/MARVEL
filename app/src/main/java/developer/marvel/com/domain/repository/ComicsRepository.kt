package developer.marvel.com.domain.repository

import developer.marvel.com.domain.entity.ComicDataWrapper
import io.reactivex.Single

interface ComicsRepository {

    fun getComics(): Single<ComicDataWrapper>

}