package developer.marvel.com.data.base

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Lazy
import developer.marvel.com.domain.entity.Failure
import io.reactivex.Single
import java.io.EOFException
import java.io.IOException
import javax.inject.Inject

abstract class BaseLocalDataSource {

    @Inject
    lateinit var moshi: Lazy<Moshi>

    protected inline fun <reified T : Any> T.toJson(): String {
        val jsonAdapter = moshi.get().adapter(T::class.java)
        return jsonAdapter.toJson(this)
    }

    protected inline fun <reified T> Single<String>.fromJson(): Single<T> {
        val jsonAdapter = moshi.get().adapter(T::class.java)
        return try {
            val t = jsonAdapter.fromJson(blockingGet())
            Single.just(t)
        } catch (e: Exception) {
            if (e is EOFException || e is IOException) {
                Single.error(Failure.NotInDatabase)
            } else {
                Single.error(e)
            }
        }
    }

    protected inline fun <reified T> Single<String>.fromJsonList(): Single<List<T>> {
        val listMyData = Types.newParameterizedType(List::class.java, T::class.java)
        val jsonAdapter = moshi.get().adapter<List<T>>(listMyData)
        return try {
            val t = jsonAdapter.fromJson(blockingGet())
            Single.just(t)
        } catch (e: Exception) {
            if (e is EOFException || e is IOException) {
                Single.error(Failure.NotInDatabase)
            } else {
                Single.error(e)
            }
        }
    }

}