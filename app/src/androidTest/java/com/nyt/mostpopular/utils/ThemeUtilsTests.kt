package com.nyt.mostpopular.utils

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
@RunWith(AndroidJUnit4::class)
class ThemeUtilsTests {

    private var appContext: Context? = null

    @Before
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getDeviceTheme() {
        val isDark = ThemeUtils.getIsDarkTheme(appContext!!)
        if (isDark) {
            Assert.assertTrue(isDark)
        } else {
            Assert.assertFalse(isDark)
        }
    }

    @After
    fun onDestroy() {
        appContext = null
    }
}
