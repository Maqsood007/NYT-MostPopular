package com.nyt.mostpopular.ui.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.nyt.mostpopular.utils.LocaleManager.createNewConfigurations
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(createNewConfigurations(newBase!!, getAppLanguage(newBase)))
    }

    abstract fun getAppLanguage(context: Context): String
}
