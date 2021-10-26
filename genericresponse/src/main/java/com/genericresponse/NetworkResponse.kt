package com.genericresponse

import java.io.IOException

sealed class NetworkResponse<out T : Any>{


    /**
     * Init  Request
     */
    data class Init(val note: String) : NetworkResponse<Nothing>()

    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T>()

    /**
     * Failure response with body
     */
    data class ApiError<T : Any>(val body: T, val code: Int) : NetworkResponse<T>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable) : NetworkResponse<Nothing>()
}