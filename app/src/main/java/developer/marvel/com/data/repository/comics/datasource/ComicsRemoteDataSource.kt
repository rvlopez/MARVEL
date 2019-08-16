package developer.marvel.com.data.repository.comics.datasource

import developer.marvel.com.data.repository.comics.ComicsApi
import developer.marvel.com.domain.entity.ComicDataWrapper
import io.reactivex.Single
import javax.inject.Inject

class ComicsRemoteDataSource @Inject constructor(
    private val comicsApi: ComicsApi
) {

    fun getComics(): Single<ComicDataWrapper> =
        comicsApi.getComics().map { it.toDomain() }

}