package com.juandiegogarcia.loginusertimetonic

import kotlinx.coroutines.runBlocking
import retrofit2.http.GET
import retrofit2.http.Query


// Retrofit API service interface for fetching all books.
interface GetAllBooksApiService {
    @GET("api.php?version=1.47&req=getAllBooks")
    suspend fun getAllBooks(
        @Query("o_u") o_u: String,
        @Query("u_c") u_c: String,
        @Query("sesskey") sesskey: String
    ): GetAllBooksModelResponse
}

/**
 * Suspended function to create and retrieve all books for a user session.
 *
 * @param o_u The user identifier.
 * @param sessionKey The session key for the user.
 * @return An instance of [GetAllBooksModelResponse] if successful.
 */
suspend fun createGetALLBooks(o_u:String, sessionKey:String): GetAllBooksModelResponse {

    return runBlocking {
        try {
            val apiService = getRetrofit().create(GetAllBooksApiService::class.java)
            val response = apiService.getAllBooks(o_u,o_u,sessionKey)

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