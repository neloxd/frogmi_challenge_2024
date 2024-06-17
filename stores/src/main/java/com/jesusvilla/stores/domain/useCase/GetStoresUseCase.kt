package com.jesusvilla.stores.domain.useCase

import com.jesusvilla.core.network.data.Resource
import com.jesusvilla.stores.data.model.StoresResponse
import com.jesusvilla.stores.data.repository.StoresRepository
import com.jesusvilla.stores.di.StoresRepositoryQualifier
import javax.inject.Inject

/**
 * Created by Jesús Villa on 15/06/24
 */
class GetStoresUseCase @Inject constructor(
    @StoresRepositoryQualifier private val storesRepository: StoresRepository,
) {
    suspend operator fun invoke(perPage: Int = 10, page: Int = 1, next: String? = null): Resource<StoresResponse> {
        return storesRepository.getStores(
            perPage = perPage,
            page = page
        )
    }
}