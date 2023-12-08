package com.juandiegogarcia.loginusertimetonic

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import retrofit2.http.Query


interface OauthKeyApiServiceApiService {
    @GET("api.php?version=1.47&req=createOauthkey")
    suspend fun createOauthKey(
        @Query("login") login: String,
        @Query("pwd") pwd: String,
        @Query("appkey") appKey: String
    ): OauthKeyModelResponse
}

suspend fun createOauthKey(login: String, pwd: String, appKey: String): OauthKeyModelResponse {
    val result = CompletableDeferred<OauthKeyModelResponse>()

    withContext(Dispatchers.IO) {
        try {
            val apiService = getRetrofit().create(OauthKeyApiServiceApiService::class.java)
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
