package com.jesusvilla.stores.data.service

import com.jesusvilla.stores.data.model.StoresResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface StoresAPI {

    @GET("stores")
    suspend fun getStores(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): Response<StoresResponse>

    @GET
    fun getNextStores(@Url url: String): Response<StoresResponse>
}