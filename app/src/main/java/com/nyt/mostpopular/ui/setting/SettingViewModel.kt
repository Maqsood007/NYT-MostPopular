package com.nyt.mostpopular.ui.setting

import androidx.lifecycle.ViewModel
import com.nyt.mostpopular.repository.NYTRepository
import com.nyt.mostpopular.utils.LanguageUtils.toggleTheLangCode
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Muhammad Maqsood on 01/08/2021.
 */
@HiltViewModel
class SettingViewModel @Inject constructor(private val nytRepository: NYTRepository) :
    ViewModel() {

    fun setIsDarkMode(isDark: Boolean) = nytRepository.setThemePreference(isDark)

    fun getAppLanguage() = nytRepository.getAppLanguage()

    fun toggleLanguage() {
        nytRepository.setAppLanguage(toggleTheLangCode(getAppLanguage()))
    }
}
