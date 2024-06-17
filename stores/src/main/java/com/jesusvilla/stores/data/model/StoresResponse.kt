package com.jesusvilla.stores.data.model

import com.google.gson.annotations.SerializedName

data class StoresResponse (
    @SerializedName("data") var data: ArrayList<Data>? = null,
    @SerializedName("meta") var meta: Meta? = null,
    @SerializedName("links") var links: Links? = null
)