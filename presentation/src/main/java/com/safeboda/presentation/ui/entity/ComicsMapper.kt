package com.safeboda.presentation.ui.entity

import developer.marvel.com.domain.entity.ComicDataWrapper
import com.safeboda.presentation.ui.mapper.Mapper

class ComicsMapper :
    Mapper<ComicDataWrapper.ComicData.Comic, ComicUI> {

    override fun mapToUI(obj: ComicDataWrapper.ComicData.Comic): ComicUI = with(obj) {
        com.safeboda.presentation.ui.entity.ComicUI(
            id,
            title,
            description,
            modified,
            urls.first().url,
            images.first().path
        )
    }

}