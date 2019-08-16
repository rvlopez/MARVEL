package developer.marvel.com.data.provider

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.inject.Inject

const val ALGORITHM_MD5 = "MD5"

class AuthenticationProvider @Inject constructor() {

    fun generateHash(timestamp: String, privateKey: String, publicKey: String): String =
        try {
            val md5Hash = timestamp + privateKey + publicKey
            val md5Encoder = MessageDigest.getInstance(ALGORITHM_MD5)
            val md5ByteArray = md5Encoder.digest(md5Hash.toByteArray())
            Arrays.toString(md5ByteArray)
        } catch (noSuchAlgorithmException: NoSuchAlgorithmException) {
            throw noSuchAlgorithmException
        }

}