package com.safeboda.data.base

import com.squareup.moshi.Moshi
import com.safeboda.domain.base.ResponseObject
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

open class BaseRemoteDataSource {

    @Inject
    protected lateinit var moshi: Lazy<Moshi>

    private val timeout = 30L
    private val retry = 1

    protected fun <RO : ResponseObject<DO>, DO : Any> modifySingle(
        single: Single<retrofit2.adapter.rxjava2.Result<RO>>,
        requestTimeout: Long = timeout,
        retryTime: Int = retry
    ): Single<DO> =
        single.flatMap { data ->
            Single.create<DO> { emitter ->

                if (data.response() == null) Timber.e("BaseRemoteDataSource: modifySingle ${data.error().toString()}")

                data.response()?.let { response ->
//                    val body: RO? = response.body()
//                    val code = response.code()
//                    val errorBody = response.errorBody()
//
//                    if (emitter.isDisposed.not()) {
//                        when {
//                            response.isSuccessful && body != null -> emitter.onSuccess(getDomainObject(body))
//                            response.isSuccessful && body == null -> emitter.onSuccess(
//                                getDomainObjectNoResponse(code)
//                            )
//                            code == UNAUTHORIZED_CODE || code == TOKEN_BLACKLISTED_CODE ->
//                                emitter.tryOnError(Failure.Unauthorized)
//                            checkCodeError -> emitter.tryOnError(codeErrorHandler!!.invoke(code))
//                            response.isSuccessful.not() -> {
//                                val failure = getFailureErrorWithErrorResponse(code, errorBody)
//                                if (checkReasonError) {
//                                    emitter.tryOnError(reasonErrorHandler!!.invoke(failure))
//                                } else {
//                                    emitter.tryOnError(failure)
//                                }
//                            }
//                            else -> emitter.tryOnError(getFailureUnknownError())
//                        }
//                    }
//
//                } ?: kotlin.run {
//                    if (emitter.isDisposed.not()) {
//                        emitter.tryOnError(getFailureError(data.error()))
//                    }

                }

            }
        }

}