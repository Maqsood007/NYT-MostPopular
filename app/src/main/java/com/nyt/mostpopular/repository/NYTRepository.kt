package com.nyt.mostpopular.repository

import com.nyt.mostpopular.repository.preference.NYTPreferences
import com.nyt.mostpopular.repository.preference.NYTPreferencesImpl
import javax.inject.Inject

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class NYTRepository @Inject constructor(
    private val nytPreferencesImpl: NYTPreferencesImpl
) : NYTPreferences {

    override fun setThemePreference(isDark: Boolean) {
        nytPreferencesImpl.setThemePreference(isDark)
    }

    override fun getIsDarkTheme() = nytPreferencesImpl.getIsDarkTheme()

    override fun setAppLanguage(langCode: String) = nytPreferencesImpl.setAppLanguage(langCode)

    override fun getAppLanguage() = nytPreferencesImpl.getAppLanguage()
}
