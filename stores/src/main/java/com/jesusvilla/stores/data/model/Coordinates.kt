package com.jesusvilla.stores.data.model

import com.google.gson.annotations.SerializedName

data class Coordinates (
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null
)