package com.safeboda.domain.base

interface ResponseObject<out DomainObject : Any> {

    fun toDomain(): DomainObject

}