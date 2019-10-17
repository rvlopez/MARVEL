package com.safeboda.data.repository.comics

import com.safeboda.data.entity.comics.ComicDataWrapperResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ComicsApi {

    @GET("comics")
    fun getComics(): Single<ComicDataWrapperResponse>

}