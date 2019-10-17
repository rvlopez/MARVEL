package com.safeboda.domain.entity

sealed class Failure(var retryAction: () -> Unit): Throwable() {

    object NotInDatabase : Failure({})

}