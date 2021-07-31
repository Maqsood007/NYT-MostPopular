package com.nyt.mostpopular.repository.preference

import android.content.SharedPreferences
import androidx.core.content.edit
import com.nyt.mostpopular.repository.preference.NYTPreferences.Companion.APP_LANGUAGE
import com.nyt.mostpopular.repository.preference.NYTPreferences.Companion.THEME_SELECTION
import com.nyt.mostpopular.utils.AppConstants.APP_DEFAULT_LANG
import javax.inject.Inject

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class NYTPreferencesImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    NYTPreferences {

    override fun setThemePreference(isDark: Boolean) {
        sharedPreferences.edit {
            putBoolean(THEME_SELECTION, isDark)
        }
    }

    override fun getIsDarkTheme() = sharedPreferences.getBoolean(THEME_SELECTION, false)

    override fun setAppLanguage(langCode: String) {

        sharedPreferences.edit {
            putString(APP_LANGUAGE, langCode)
        }
    }

    override fun getAppLanguage() = sharedPreferences.getString(APP_LANGUAGE, APP_DEFAULT_LANG)!!
}
