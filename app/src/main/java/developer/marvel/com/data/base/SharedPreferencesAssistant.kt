package developer.marvel.com.data.base

import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single

class SharedPreferencesAssistant(
    private val sharedPreferences: SharedPreferences
) {

    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, default: String = ""): Single<String> =
        Single.just(sharedPreferences.getString(key, default) ?: "")

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Single<Boolean> =
        Single.just(sharedPreferences.getBoolean(key, false))

    fun saveInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, default: Int = Constants.DEFAULT_INT): Single<Int> =
        Single.just(sharedPreferences.getInt(key, default))

    fun removeKey(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun nuke(): Completable = Completable.create { emitter ->
        try {
            sharedPreferences.edit().clear().apply()
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

}