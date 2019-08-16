package developer.marvel.com.domain.entity

sealed class Failure(var retryAction: () -> Unit): Throwable() {

    object NotInDatabase : Failure({})

}