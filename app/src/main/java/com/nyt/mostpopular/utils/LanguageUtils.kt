package com.nyt.mostpopular.utils

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
object LanguageUtils {

    fun isRTL(code: String) = code == AppConstants.APP_RTL_LANG

    fun toggleTheLangCode(code: String) =
        if (code == AppConstants.APP_DEFAULT_LANG) AppConstants.APP_RTL_LANG else AppConstants.APP_DEFAULT_LANG
}