package com.safeboda.presentation.ui.entity

import developer.marvel.com.presentation.ui.recyclerview.RecyclerViewObject
import java.util.*

class ComicUI(
    val id: Int,
    val title: String,
    val description: String,
    val modified: Date,
    val urls: String,
    val images: String
) : RecyclerViewObject {

    override var itemViewType: RecyclerViewObject.ItemViewType =
        RecyclerViewObject.ItemViewType.ITEM

    override var addDivider: Boolean = false

}