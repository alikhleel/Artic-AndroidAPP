package com.alikhalil.demo1.common

sealed class UIState<T>(
    val responseData: T? = null,
    open val message: String? = null
) {
    class Loading<T> : UIState<T>()
    class Success<T>(data: T?) : UIState<T>(responseData = data)
    class Error<T>(error: String) : UIState<T>(message = error)

    data class Empty<T>(
        val title: String? = null,
        override val message: String? = null, val iconRes: Int = -1
    ) : UIState<T>()
}

