package developer.marvel.com.data.repository.comics

import developer.marvel.com.data.entity.comics.ComicDataWrapperResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ComicsApi {

    @GET("comics")
    fun getComics(): Single<ComicDataWrapperResponse>

}