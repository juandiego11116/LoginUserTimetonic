
package com.juandiegogarcia.loginusertimetonic

/**
 * Suspended function to fetch all books for a user session.
 *
 * @param o_u The user identifier.
 * @param sessionKey The session key for the user.
 * @return An instance of [GetAllBooksModelResponse] if successful, otherwise null.
 */
suspend fun BooksFetch(o_u:String, sessionKey: String): GetAllBooksModelResponse? {
    return try {
        createGetALLBooks(o_u,sessionKey)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}