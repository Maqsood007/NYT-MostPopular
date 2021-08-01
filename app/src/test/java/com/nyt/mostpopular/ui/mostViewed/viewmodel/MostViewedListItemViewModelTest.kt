package com.nyt.mostpopular.ui.mostViewed.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nyt.mostpopular.repository.models.Result
import com.nyt.mostpopular.ui.mostviewed.viewmodel.MostViewedListItemViewModel
import com.nyt.mostpopular.utils.MockDataUtils
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Muhammad Maqsood on 01/08/2021.
 */
@RunWith(JUnit4::class)
class MostViewedListItemViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    lateinit var mostViewedListItemViewModel: MostViewedListItemViewModel
    var result: List<Result>? = null

    @Before
    fun setUp() {

        mostViewedListItemViewModel = MostViewedListItemViewModel()
        result = MockDataUtils.getMockedResults()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun bind() {
        mostViewedListItemViewModel.bind(result?.get(0))
    }

    @Test
    fun `getAvatar Not Null`() {
        Assert.assertNotNull(mostViewedListItemViewModel.getAvatar())
    }

    @Test
    fun `getTitle Not Null`() {
        Assert.assertNotNull(mostViewedListItemViewModel.getTitle())
    }

    @Test
    fun `getAuthorName Not Null`() {
        Assert.assertNotNull(mostViewedListItemViewModel.getAuthorName())
    }

    @Test
    fun `getCategory Not Null`() {
        Assert.assertNotNull(mostViewedListItemViewModel.getCategory())
    }

    @Test
    fun `getDate Not Null`() {
        Assert.assertNotNull(mostViewedListItemViewModel.getDate())
    }
}
