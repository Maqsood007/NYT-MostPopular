package com.nyt.mostpopular.utils

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
sealed class NetworkState<out T> {

    data class Success<out T>(val data: T) : NetworkState<T>()
    data class Failure<out T>(val error: T) : NetworkState<T>()
    data class Loading<out T>(val loadingType: T) : NetworkState<T>()
}
