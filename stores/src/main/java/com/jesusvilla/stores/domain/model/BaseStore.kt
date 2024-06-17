package com.jesusvilla.stores.domain.model

interface BaseStore {
    val isLoading: Boolean
        get() = false
}