package com.safeboda.domain.entity

import java.util.*

class ComicDataWrapper(
    val httpCode: Int,
    val status: String,
    val comicDataResponse: ComicData
) {

    class ComicData(
        val count: Int,
        val comics: List<Comic>
    ) {

        class Comic(
            val id: Int,
            val title: String,
            val description: String,
            val modified: Date,
            val urls: List<Url>,
            val images: List<Image>,
            val creators: Creators
        ) {

            class Url(
                val type: String,
                val url: String
            )

            class Image(
                val path: String,
                val extension: String
            )

            class Creators(
                val ceratorSummary: CreatorSummary
            ) {

                class CreatorSummary(
                    val name: String,
                    val role: String
                )

            }
        }

    }

}