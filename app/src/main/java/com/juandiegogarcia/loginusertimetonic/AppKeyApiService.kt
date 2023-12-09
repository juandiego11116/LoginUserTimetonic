package com.juandiegogarcia.loginusertimetonic

import retrofit2.Response
import retrofit2.http.GET

// This interface defines the API service for obtaining an app key.
interface AppKeyApiService {
    // This suspending function makes an HTTP GET request.
    // The URL specifies the API endpoint and includes parameters for:
    // version, request type, app name.
    @GET("api.php?version=1.47&req=createAppkey&appname=loginusertimetonic")
    suspend fun getAppKey(): Response<AppKeyModelResponse>
}

// Create an instance of the Retrofit service by calling the getRetrofit function.
val appKeyService = getRetrofit().create(AppKeyApiService::class.java)

