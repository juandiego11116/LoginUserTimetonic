package com.juandiegogarcia.loginusertimetonic

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// This interface defines the API service for obtaining an session key.
interface SessionKeyApiService {
    // This suspending function makes an HTTP GET request.
    // The URL specifies the API endpoint and includes parameters for:
    // version, request type, o_u, u_c and authentication key
    @GET("api.php?version=1.47&req=createSesskey")
    suspend fun createSessionKey(
        @Query("o_u") o_u: String,
        @Query("u_c") u_c: String,
        @Query("oauthkey") oauthkey: String
    ): SessionModelResponse
}

/**
 * Suspended function to create a session key using the provided parameters.
 *
 * @param o_u The value for "o_u" parameter.
 * @param oauthkey The value for authentication key parameter.
 * @return A [SessionModelResponse] representing the result of the session key creation.
 * @throws RuntimeException If there is a failure during the session key creation process.
 */
suspend fun createSessionKey(o_u:String, oauthkey:String): SessionModelResponse {

    return runBlocking {
        try {
            // Create an instance of the SessionKeyApiService interface using Retrofit.
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