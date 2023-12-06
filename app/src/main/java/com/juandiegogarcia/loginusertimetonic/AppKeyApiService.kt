package com.juandiegogarcia.loginusertimetonic

import retrofit2.Response
import retrofit2.http.GET

interface AppKeyApiService {
    @GET("api.php?version=1.47&req=createAppkey&appname=loginusertimetonic")
    suspend fun getAppKey(): Response<AppKeyModelResponse>
}

val appKeyService = getRetrofit().create(AppKeyApiService::class.java)

