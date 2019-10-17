package com.safeboda.data.entity.comics

import com.squareup.moshi.Json
import com.safeboda.domain.base.ResponseObject
import com.safeboda.domain.entity.ComicDataWrapper
import java.util.*

class ComicDataWrapperResponse(
    @Json(name = "code") val httpCode: Int,
    @Json(name = "status") val status: String,
    @Json(name = "data") val comicDataResponse: ComicDataResponse
) : ResponseObject<ComicDataWrapper> {

    override fun toDomain(): ComicDataWrapper =
        ComicDataWrapper(
            httpCode,
            status,
            comicDataResponse.toDomain()
        )

    class ComicDataResponse(
        @Json(name = "count") val count: Int,
        @Json(name = "results") val comics: List<ComicResponse>
    ) : ResponseObject<ComicDataWrapper.ComicData> {

        override fun toDomain(): ComicDataWrapper.ComicData =
            ComicDataWrapper.ComicData(
                count,
                comics.map { it.toDomain() }
            )

        class ComicResponse(
            @Json(name = "id") val id: Int,
            @Json(name = "title") val title: String,
            @Json(name = "description") val description: String,
            @Json(name = "modified") val modified: Date,
            @Json(name = "urls") val urls: List<UrlResponse>,
            @Json(name = "images") val images: List<ImageResponse>,
            @Json(name = "creators") val creators: CreatorsResponse
        ) : ResponseObject<ComicDataWrapper.ComicData.Comic> {

            override fun toDomain(): ComicDataWrapper.ComicData.Comic =
                ComicDataWrapper.ComicData.Comic(
                    id,
                    title,
                    description,
                    modified,
                    urls.map { it.toDomain() },
                    images.map { it.toDomain() },
                    creators.toDomain()
                )

            class UrlResponse(
                @Json(name = "type") val type: String,
                @Json(name = "url") val url: String
            ) : ResponseObject<ComicDataWrapper.ComicData.Comic.Url> {

                override fun toDomain(): ComicDataWrapper.ComicData.Comic.Url =
                    ComicDataWrapper.ComicData.Comic.Url(type, url)

            }

            class ImageResponse(
                @Json(name = "path") val path: String,
                @Json(name = "extension") val extension: String
            ) : ResponseObject<ComicDataWrapper.ComicData.Comic.Image> {

                override fun toDomain(): ComicDataWrapper.ComicData.Comic.Image =
                    ComicDataWrapper.ComicData.Comic.Image(path, extension)

            }

            class CreatorsResponse(
                @Json(name = "items") val creatorSummary: CreatorSummaryResponse
            ) : ResponseObject<ComicDataWrapper.ComicData.Comic.Creators> {

                override fun toDomain(): ComicDataWrapper.ComicData.Comic.Creators =
                    ComicDataWrapper.ComicData.Comic.Creators(creatorSummary.toDomain())

                class CreatorSummaryResponse(
                    @Json(name = "name") val name: String,
                    @Json(name = "role") val role: String
                ) : ResponseObject<ComicDataWrapper.ComicData.Comic.Creators.CreatorSummary> {

                    override fun toDomain(): ComicDataWrapper.ComicData.Comic.Creators.CreatorSummary =
                        ComicDataWrapper.ComicData.Comic.Creators.CreatorSummary(name, role)

                }

            }

        }

    }

}