package com.nyt.mostpopular.utils

import com.nyt.mostpopular.utils.MockDataUtils.getMockedFailureMedia
import com.nyt.mostpopular.utils.MockDataUtils.getMockedSuccessMedia
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
class DataParsingUtilsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getThumbnailSuccess() {

        val mockedData = getMockedSuccessMedia()
        Assert.assertNotNull(DataParsingUtils.getThumbnail(mockedData))
    }

    @Test
    fun getThumbnailFailure() {

        val mockedData = getMockedFailureMedia()
        Assert.assertNull(DataParsingUtils.getThumbnail(mockedData))
    }

}