package com.jesusvilla.stores.data.repository

import com.jesusvilla.core.network.data.Resource
import com.jesusvilla.core.network.data.processedNetworkResource
import com.jesusvilla.stores.data.model.StoresResponse
import com.jesusvilla.stores.data.service.StoresAPI
import com.jesusvilla.stores.di.StoresQualifier
import javax.inject.Inject

class StoresRepositoryImpl @Inject constructor(
    @StoresQualifier private val storesService: StoresAPI
) : StoresRepository {

    override suspend fun getStores(perPage: Int, page: Int): Resource<StoresResponse> {
        return processedNetworkResource(
            {
                storesService.getStores(
                    perPage = perPage,
                    page = page
                )
            },
            {
                it
            }
        )
    }
}