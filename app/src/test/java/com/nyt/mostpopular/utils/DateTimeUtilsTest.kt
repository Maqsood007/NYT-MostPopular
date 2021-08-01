package com.nyt.mostpopular.utils

import org.junit.Assert
import org.junit.Test

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class DateTimeUtilsTest {

    @Test
    fun getParsedDateSuccess() {

        val input = "2021-09-30"
        val expected = "Sep 30, 2021"

        Assert.assertEquals(expected, DateTimeUtils.getParsedDate(input))
    }

    @Test
    fun getParsedDateFailure() {

        val input = "2021-09-301"
        val expected = "Se 30, 2021"

        Assert.assertNotEquals(expected, DateTimeUtils.getParsedDate(input))
    }

}