package com.genericresponse

sealed class CommState<out T : Any> {

    data class Loading<T : Any>(val state: String = "Loading") : CommState<T>()
    data class Success<T : Any>(val body: T) : CommState<T>()
    data class Error<T : Any>(val state: String = "Error") : CommState<T>()

}