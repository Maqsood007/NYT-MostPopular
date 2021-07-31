package com.nyt.mostpopular.ui.mostviewed.viewmodel

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.facebook.shimmer.ShimmerFrameLayout
import com.nyt.mostpopular.repository.NYTRepository
import com.nyt.mostpopular.repository.models.MostViewedResponse
import com.nyt.mostpopular.repository.models.Result
import com.nyt.mostpopular.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
enum class RequestType {

    LOAD,
    PULL_TO_REFRESH
}

@HiltViewModel
class MostViewedViewModel @Inject constructor(private val nytRepository: NYTRepository) :
    ViewModel() {

    private val TAG = MostViewedViewModel::class.simpleName

    val mostViewedList = MutableLiveData<List<Result?>>()

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorLayoutVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val pullToRefreshVisibility: MutableLiveData<Boolean> = MutableLiveData()

    val mostViewedState = MutableLiveData<NetworkState<*>>()

    private var sectionsToLoad: String = "all-sections"
    private var periodsToLoad: String = "7"

    fun getMostViewedArticles(requestType: RequestType) {

        viewModelScope.launch {

            // State as loading
            mostViewedState.value = NetworkState.Loading(requestType)
            try {

                val response = withContext(Dispatchers.Default) {
                    nytRepository.getMostViewedArticles(sectionsToLoad, periodsToLoad)
                }
                // Update state as data received/
                mostViewedState.value = NetworkState.Success(response)
            } catch (e: Exception) {
                // State as failure
                mostViewedState.value = NetworkState.Failure(e.localizedMessage)
            }
        }
    }

    fun onFetchMostViewedArticlesStart(requestType: RequestType) {

        if (requestType == RequestType.LOAD) {
            loadingVisibility.value = true
        }

        errorMessage.value = null
        errorLayoutVisibility.value = false
    }

    fun onFetchMostViewedArticlesFinish() {

        loadingVisibility.value = false
        pullToRefreshVisibility.value = false
    }

    fun handleResponse(mostViewedResponse: MostViewedResponse) {
        mostViewedList.value = mostViewedResponse.results!!
    }

    fun handleError(error: Throwable) {
        onFetchMostViewedArticlesFinish()
        errorMessage.value = error.message

        if (mostViewedList.value == null || mostViewedList.value?.size == 0)
            errorLayoutVisibility.value = true
    }
}

@BindingAdapter("bind:loadingVisibility")
fun layoutVisibility(view: ShimmerFrameLayout, visibility: Boolean) {

    if (visibility) {
        view.startShimmerAnimation()
        view.visibility = View.VISIBLE
    } else {
        view.startShimmerAnimation()
        view.visibility = View.GONE
    }
}

@BindingAdapter("bind:isRefreshing")
fun pullToRefreshVisibility(view: SwipeRefreshLayout?, visibility: Boolean) {
    view?.isRefreshing = visibility
}
