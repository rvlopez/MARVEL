package developer.marvel.com.domain.base

interface ResponseObject<out DomainObject : Any> {

    fun toDomain(): DomainObject

}