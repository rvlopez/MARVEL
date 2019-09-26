package developer.marvel.com.presentation.ui.mapper

interface Mapper<DomainObject, UIObject> {

    fun mapToUI(obj: DomainObject): UIObject

}