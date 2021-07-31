package com.nyt.mostpopular.repository.preference

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
interface NYTPreferences {

    fun setThemePreference(isDark: Boolean)
    fun getIsDarkTheme(): Boolean

    fun setAppLanguage(langCode: String)
    fun getAppLanguage(): String

    companion object {

        const val THEME_SELECTION = "THEME_SELECTION"
        const val APP_LANGUAGE = "APP_LANGUAGE"
    }
}
