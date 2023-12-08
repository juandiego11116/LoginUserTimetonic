package com.juandiegogarcia.loginusertimetonic

import com.google.gson.annotations.SerializedName

data class AppKeyModelResponse(
    @SerializedName("status") val status: String,
    @SerializedName("appkey")val appKey: String,
    @SerializedName("id")val id: String,
    @SerializedName("createdVNB")val createdVNB: String,
    @SerializedName("req")val req: String
)
