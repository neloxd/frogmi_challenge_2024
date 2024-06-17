package com.jesusvilla.stores.data.repository

import com.jesusvilla.core.network.data.Resource
import com.jesusvilla.core.network.data.processedNetworkResource
import com.jesusvilla.stores.data.model.StoresResponse
import com.jesusvilla.stores.data.service.StoresDynamicAPI
import com.jesusvilla.stores.di.StoresDynamicQualifiers
import javax.inject.Inject

class StoresDynamicRepositoryImpl @Inject constructor(
    @StoresDynamicQualifiers private val baseDynamicAPI: StoresDynamicAPI
) : StoresDynamicRepository {

    override suspend fun getStores(url: String): Resource<StoresResponse> {
        return processedNetworkResource(
            {
                //baseDynamicAPI.fetch(url)
                baseDynamicAPI.getStores(10, 1)
            },
            {
                it
            }
        )
    }
}