package com.example.compose.utils
sealed class ApiStatus<out T>() {
    object Loading : ApiStatus<Nothing>()
    class Failure(val msg: Throwable) : ApiStatus<Nothing>()
    class Success<T>(val data: T) : ApiStatus<T>()
    object Empty : ApiStatus<Nothing>()
}