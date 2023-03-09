package ir.aris.digikala.util

import ir.aris.digikala.BuildConfig

object Constants {
    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"

    const val DATASTORE_NAME = "DIGIKALA_DATA_STORE"

    const val API_KEY = BuildConfig.X_API_KEY
    var USER_LANGUAGE = "USER_LANGUAGE"

    const val TIMEOUT_IN_SECOND: Long = 60
    const val BASE_URL = "https://dig-za0p.onrender.com/api/"
}