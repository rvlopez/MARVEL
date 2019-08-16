package developer.marvel.com.data.network.interceptor

import developer.marvel.com.BuildConfig
import developer.marvel.com.data.network.ApiKey
import developer.marvel.com.data.provider.AuthenticationProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
    private val authenticationProvider: AuthenticationProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = System.currentTimeMillis().toString()
        val hash = authenticationProvider.generateHash(
            timestamp,
            BuildConfig.PRIVATE_API_KEY,
            BuildConfig.PUBLIC_API_KEY
        )

        var request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter(ApiKey.TIMESTAMP_KEY, timestamp)
            .addQueryParameter(ApiKey.API_KEY, BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter(ApiKey.HASH_KEY, hash)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}