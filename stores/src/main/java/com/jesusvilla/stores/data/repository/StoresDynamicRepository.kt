package com.jesusvilla.stores.data.repository

import com.jesusvilla.core.network.data.Resource
import com.jesusvilla.stores.data.model.StoresResponse

interface StoresDynamicRepository {
    @Throws(Exception::class)
    suspend fun getStores(url: String): Resource<StoresResponse>
}