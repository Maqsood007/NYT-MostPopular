package com.nyt.mostpopular.utils

import org.junit.Assert
import org.junit.Test

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class LanguageUtilsTest {

    @Test
    fun isRTLSuccess() {

        val input = "ar"
        Assert.assertTrue(LanguageUtils.isRTL(input))
    }

    @Test
    fun isRTLFailure() {

        val input = "en"
        Assert.assertFalse(LanguageUtils.isRTL(input))
    }

    @Test
    fun toggleTheLangCodeToArabicSuccess() {

        val input = "en"
        val output = "ar"

        Assert.assertEquals(output, LanguageUtils.toggleTheLangCode(input))
    }

    @Test
    fun toggleTheLangCodeToEnglishSuccess() {

        val input = "ar"
        val output = "en"

        Assert.assertEquals(output, LanguageUtils.toggleTheLangCode(input))
    }

    @Test
    fun toggleTheLangCodeToArabicFromUnknownSuccess() {

        val input = "fr"
        val output = "ar"

        Assert.assertNotEquals(output, LanguageUtils.toggleTheLangCode(input))
    }
}