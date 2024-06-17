package com.jesusvilla.stores.domain.useCase

import com.jesusvilla.core.network.data.Resource
import com.jesusvilla.stores.data.model.StoresResponse
import com.jesusvilla.stores.data.repository.StoresDynamicRepository
import com.jesusvilla.stores.di.StoresDynamicRepositoryQualifier
import javax.inject.Inject

/**
 * Created by Jesús Villa on 15/06/24
 */
class GetMoreStoresUseCase @Inject constructor(
    @StoresDynamicRepositoryQualifier private val storesDynamicRepository: StoresDynamicRepository,
) {
    suspend operator fun invoke(next: String): Resource<StoresResponse> {
        return storesDynamicRepository.getStores(next)
    }
}