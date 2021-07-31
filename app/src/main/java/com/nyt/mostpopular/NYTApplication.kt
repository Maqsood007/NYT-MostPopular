package com.nyt.mostpopular

import android.app.Application
import com.nyt.mostpopular.repository.NYTRepository
import com.nyt.mostpopular.utils.ThemeUtils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Created by Muhammad Maqsood on 04/10/2020.
 */
@HiltAndroidApp
class NYTApplication : Application() {

    @Inject
    lateinit var nytRepository: NYTRepository

    override fun onCreate() {
        super.onCreate()

        if (nytRepository.getIsDarkTheme()) ThemeUtils.enableDarkTheme() else ThemeUtils.enableLightTheme()
    }

    fun getAppLanguage() = nytRepository.getAppLanguage()
}
