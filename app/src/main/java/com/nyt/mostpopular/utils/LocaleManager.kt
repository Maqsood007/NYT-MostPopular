package com.nyt.mostpopular.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import java.util.Locale

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
object LocaleManager {

    fun createNewConfigurations(context: Context, langCode: String): Context {
        var configuration = getConfiguration(context)
        configuration = setUpConfigLocale(configuration, langCode)
        return context.createConfigurationContext(configuration)
    }

    private fun getConfiguration(
        context: Context
    ) = Configuration(context.resources.configuration)

    private fun setUpConfigLocale(configuration: Configuration, langCode: String): Configuration {
        val locale = Locale(langCode)
        configuration.setLocale(locale)
        return configuration
    }

    fun restart(context: Activity) {

        context.finish()
        val i: Intent = context.baseContext.packageManager
            .getLaunchIntentForPackage(context.baseContext.packageName)!!
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(i)
        context.overridePendingTransition(0, 0)
    }
}
