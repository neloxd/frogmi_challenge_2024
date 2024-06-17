package com.jesusvilla.stores.domain.model

data class DataStore(
    val totalStores: Int,
    val perPage: Int,
    val next: String? = null,
    val stores: List<StoreUI>
)
