package developer.marvel.com.presentation.ui.entity

import developer.marvel.com.domain.entity.ComicDataWrapper
import developer.marvel.com.presentation.ui.mapper.Mapper

class ComicsMapper : Mapper<ComicDataWrapper.ComicData.Comic, ComicUI> {

    override fun mapToUI(obj: ComicDataWrapper.ComicData.Comic): ComicUI = with(obj) {
        ComicUI(
            id,
            title,
            description,
            modified,
            urls.first().url,
            images.first().path
        )
    }

}