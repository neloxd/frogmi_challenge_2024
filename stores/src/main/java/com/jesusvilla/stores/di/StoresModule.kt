package com.jesusvilla.stores.di

import com.jesusvilla.core.network.connection.RetrofitApi
import com.jesusvilla.core.network.connection.RetrofitDynamic
import com.jesusvilla.stores.data.repository.StoresDynamicRepository
import com.jesusvilla.stores.data.repository.StoresDynamicRepositoryImpl
import com.jesusvilla.stores.data.repository.StoresRepository
import com.jesusvilla.stores.data.repository.StoresRepositoryImpl
import com.jesusvilla.stores.data.service.StoresAPI
import com.jesusvilla.stores.data.service.StoresDynamicAPI
import com.jesusvilla.stores.domain.useCase.GetMoreStoresUseCase
import com.jesusvilla.stores.domain.useCase.GetStoresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object StoresModule {
    @Provides
    @ViewModelScoped
    @StoresQualifier
    fun provideStoresApi(@RetrofitApi retrofit: Retrofit): StoresAPI {
        return retrofit.create(StoresAPI::class.java)
    }

    @Provides
    @ViewModelScoped
    @StoresDynamicQualifiers
    fun provideStoresDynamicApi(@RetrofitDynamic retrofit: Retrofit): StoresDynamicAPI {
        return retrofit.create(StoresDynamicAPI::class.java)
    }

    @Provides
    @ViewModelScoped
    @StoresRepositoryQualifier
    fun provideStoresRepository(@StoresQualifier storesAPI: StoresAPI): StoresRepository {
        return StoresRepositoryImpl(storesAPI)
    }

    @Provides
    @ViewModelScoped
    @StoresDynamicRepositoryQualifier
    fun provideStoresDynamicRepository(@StoresDynamicQualifiers baseDynamicAPI: StoresDynamicAPI): StoresDynamicRepository {
        return StoresDynamicRepositoryImpl(baseDynamicAPI)
    }

    @Provides
    @ViewModelScoped
    @GetStoresUseCaseQualifier
    fun provideGetStoresUseCase(@StoresRepositoryQualifier storesRepository: StoresRepository): GetStoresUseCase {
        return GetStoresUseCase(storesRepository)
    }

    @Provides
    @ViewModelScoped
    @GetMoreStoresUseCaseQualifier
    fun provideGetMoreStoresUseCase(@StoresDynamicRepositoryQualifier storesDynamicRepository: StoresDynamicRepository): GetMoreStoresUseCase {
        return GetMoreStoresUseCase(storesDynamicRepository)
    }
}