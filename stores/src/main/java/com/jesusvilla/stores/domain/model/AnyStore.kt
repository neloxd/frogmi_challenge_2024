package com.jesusvilla.stores.domain.model

data class AnyStore(
    val title: String = "AnyProperty"
): BaseStore {
    override val isLoading: Boolean = true
}
