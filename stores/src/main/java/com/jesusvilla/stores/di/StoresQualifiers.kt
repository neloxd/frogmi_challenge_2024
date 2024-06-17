package com.jesusvilla.stores.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StoresQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StoresDynamicQualifiers

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StoresRepositoryQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StoresDynamicRepositoryQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GetStoresUseCaseQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class GetMoreStoresUseCaseQualifier