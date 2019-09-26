package developer.marvel.com.presentation.ui.recyclerview

interface RecyclerViewObject {

    var itemViewType: ItemViewType

    var addDivider: Boolean

    enum class ItemViewType {
        SMALL_LOADING,
        FULL_ERROR,
        SMALL_ERROR,
        ITEM,
        EMPTY,
        HEADER,
        ITEM_PLACEHOLDER,
        HEADER_PLACEHOLDER
    }

}