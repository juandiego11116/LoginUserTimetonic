package com.juandiegogarcia.loginusertimetonic

/**
 * Suspended function for user login authentication.
 * calling 3 endpoints for authentication
 * @param login The user's login or user identifier.
 * @param password The user's password.
 * @return A [SessionModelResponse] representing the user's session, or null if authentication fails.
 */
suspend fun loginApp(login: String, password: String): SessionModelResponse? {
    return try {
        val appKey = appKeyService.getAppKey().body()?.appKey ?: ""
        val oauthKey = createOauthKey(login, password, appKey)
        createSessionKey(oauthKey.o_u, oauthKey.oauthkey)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}





