package com.nyt.mostpopular.ui.mostViewed.viewmodel

import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nyt.mostpopular.repository.NYTRepository
import com.nyt.mostpopular.repository.preference.NYTPreferencesImpl
import com.nyt.mostpopular.repository.server.NytAPI
import com.nyt.mostpopular.ui.mostviewed.viewmodel.MostViewedViewModel
import com.nyt.mostpopular.ui.mostviewed.viewmodel.RequestType
import com.nyt.mostpopular.utils.MockDataUtils
import com.nyt.mostpopular.utils.NetworkState
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Muhammad Maqsood on 01/08/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class MostViewedViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var nytAPI: NytAPI

    lateinit var mostViewedViewModel: MostViewedViewModel

    @After
    fun checkMockito() {
        Mockito.validateMockitoUsage()
    }

    @Before
    fun setUp() {
        mostViewedViewModel =
            MostViewedViewModel(
                NYTRepository(
                    NYTPreferencesImpl((sharedPreferences)),
                    nytAPI)
                )
    }

    @Test
    fun `stateLoading Load`() {

        mostViewedViewModel.mostViewedState.value = NetworkState.Loading(RequestType.LOAD)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Loading).loadingType
        Assert.assertEquals(RequestType.LOAD, state)
    }

    @Test
    fun `stateLoading PullToRefresh`() {

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Loading(RequestType.PULL_TO_REFRESH)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Loading).loadingType
        Assert.assertEquals(RequestType.PULL_TO_REFRESH, state)
    }

    @Test
    fun `stateLoading Load Failure`() {

        mostViewedViewModel.mostViewedState.value = NetworkState.Loading(RequestType.LOAD)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Loading).loadingType
        Assert.assertNotEquals(RequestType.PULL_TO_REFRESH, state)
    }

    @Test
    fun `stateLoading PullToRefresh Failure`() {

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Loading(RequestType.PULL_TO_REFRESH)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Loading).loadingType
        Assert.assertNotEquals(RequestType.LOAD, state)
    }

    @Test
    fun `stateError Failure`() {

        val error = "This Is Error"

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Failure(error)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Failure).error
        Assert.assertEquals(error, state)
    }

    @Test
    fun `stateError Null`() {

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Failure(null)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Failure).error
        Assert.assertNull(state)
    }

    @Test
    fun `stateData Success`() {

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Success(MockDataUtils.getMockedNewsResponse())

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Success).data
        Assert.assertNotNull(state)
    }

    @Test
    fun `stateData Null`() {

        mostViewedViewModel.mostViewedState.value =
            NetworkState.Success(null)

        val state = (mostViewedViewModel.mostViewedState.value as NetworkState.Success).data
        Assert.assertNull(state)
    }

    @Test
    fun `loadingVisibility updated true`() {

        mostViewedViewModel.loadingVisibility.value = true
        Assert.assertTrue(mostViewedViewModel.loadingVisibility.value as Boolean)
    }

    @Test
    fun `loadingVisibility updated false`() {

        mostViewedViewModel.loadingVisibility.value = false
        Assert.assertFalse(mostViewedViewModel.loadingVisibility.value as Boolean)
    }

    @Test
    fun `errorLayoutVisibility updated true`() {

        mostViewedViewModel.errorLayoutVisibility.value = true
        Assert.assertTrue(mostViewedViewModel.errorLayoutVisibility.value as Boolean)
    }

    @Test
    fun `errorLayoutVisibility updated false`() {

        mostViewedViewModel.errorLayoutVisibility.value = false
        Assert.assertFalse(mostViewedViewModel.errorLayoutVisibility.value as Boolean)
    }

    @Test
    fun `pullToRefreshVisibility updated true`() {

        mostViewedViewModel.pullToRefreshVisibility.value = true
        Assert.assertTrue(mostViewedViewModel.pullToRefreshVisibility.value as Boolean)
    }

    @Test
    fun `pullToRefreshVisibility updated false`() {

        mostViewedViewModel.pullToRefreshVisibility.value = false
        Assert.assertFalse(mostViewedViewModel.pullToRefreshVisibility.value as Boolean)
    }

    @Test
    fun `onFetchMostViewedArticlesStart when loading`() {

        mostViewedViewModel.onFetchMostViewedArticlesStart(RequestType.LOAD)

        Assert.assertTrue(mostViewedViewModel.loadingVisibility.value == true)
        Assert.assertNull(mostViewedViewModel.errorMessage.value)
        Assert.assertFalse(mostViewedViewModel.errorLayoutVisibility.value as Boolean)
    }

    @Test
    fun `onFetchMostViewedArticlesStart when refreshing`() {

        mostViewedViewModel.onFetchMostViewedArticlesStart(RequestType.PULL_TO_REFRESH)

        Assert.assertFalse(mostViewedViewModel.loadingVisibility.value == true)
        Assert.assertNull(mostViewedViewModel.errorMessage.value)
        Assert.assertFalse(mostViewedViewModel.errorLayoutVisibility.value as Boolean)
    }

    @Test
    fun `onFetchMostViewedArticles when Finish`() {

        mostViewedViewModel.onFetchMostViewedArticlesFinish()

        Assert.assertFalse(mostViewedViewModel.loadingVisibility.value == true)
        Assert.assertFalse(mostViewedViewModel.pullToRefreshVisibility.value as Boolean)
    }

    @Test
    fun `handleResponse Success`() {

        mostViewedViewModel.handleResponse(MockDataUtils.getMockedNewsResponse())
        Assert.assertNotNull(mostViewedViewModel.mostViewedList.value)
    }

    @Test
    fun `handleError throwable`() {

        val errorMessage = "Error Occurred"
        val throwable = Throwable(errorMessage)
        mostViewedViewModel.handleError(throwable)

        `onFetchMostViewedArticles when Finish`()

        Assert.assertEquals(mostViewedViewModel.errorMessage.value, errorMessage)
    }

    @After
    fun tearDown() {
    }
}
