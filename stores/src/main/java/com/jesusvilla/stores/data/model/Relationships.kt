package com.jesusvilla.stores.data.model

import com.google.gson.annotations.SerializedName

data class Relationships (

    @SerializedName("brands") var brands : Brands? = null,
    @SerializedName("zones") var zones  : Zones?  = null

)
