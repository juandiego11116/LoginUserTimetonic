
package com.juandiegogarcia.loginusertimetonic

suspend fun BooksFetch(o_u:String, sessionKey: String): GetAllBooksModelResponse? {
    return try {
        createGetALLBooks(o_u,sessionKey)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}