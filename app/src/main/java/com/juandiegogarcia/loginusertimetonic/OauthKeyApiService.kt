package com.juandiegogarcia.loginusertimetonic

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import retrofit2.http.Query

// This interface defines the API service for obtaining an Authentication Key
interface OauthKeyApiService {
    // This suspending function makes an HTTP GET request.
    // The URL specifies the API endpoint and includes parameters for:
    // version, request type, login, password and application Key
    @GET("api.php?version=1.47&req=createOauthkey")
    suspend fun createOauthKey(
        @Query("login") login: String,
        @Query("pwd") pwd: String,
        @Query("appkey") appKey: String
    ): OauthKeyModelResponse
}

/**
 * Suspended function to create a session key using the provided parameters.
 *
 * @param login The value for user o log in parameter.
 * @param pwd The value for password key parameter.
 * @param appKey The value for authentication key parameter.
 * @return A [OauthKeyModelResponse] representing the result of the authentication key creation.
 * @throws RuntimeException If there is a failure during the session key creation process.
 */
suspend fun createOauthKey(login: String, pwd: String, appKey: String): OauthKeyModelResponse {
    val result = CompletableDeferred<OauthKeyModelResponse>()

    withContext(Dispatchers.IO) {
        try {
            // Create an instance of the OauthKeyApiService interface using Retrofit.
            val apiService = getRetrofit().create(OauthKeyApiService::class.java)
            val response = apiService.createOauthKey(login, pwd, appKey)

            if (response.status == "ok") {
                result.complete(response)
            } else {
                result.completeExceptionally(RuntimeException("Failed to retrieve OauthKey. Status: ${response.status}"))
            }
        } catch (e: Exception) {
            result.completeExceptionally(RuntimeException("Exception: ${e.message}"))
        }
    }
    return result.await()
}
