package com.juandiegogarcia.loginusertimetonic

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionKeyApiService {
    @GET("api.php?version=1.47&req=createSesskey")
    suspend fun createSessionKey(
        @Query("o_u") o_u: String,
        @Query("u_c") u_c: String,
        @Query("oauthkey") oauthkey: String
    ): SessionModelResponse
}

suspend fun createSessionKey(o_u:String, oauthkey:String): SessionModelResponse {

    return runBlocking {
        try {
            val apiService = getRetrofit().create(SessionKeyApiService::class.java)
            val response = apiService.createSessionKey(o_u, o_u, oauthkey)

            if (response.status == "ok") {
                response
            } else {
                throw RuntimeException("Failed to retrieve SessionKey. Status: ${response.status}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Exception: ${e.message}")
        }
    }
}