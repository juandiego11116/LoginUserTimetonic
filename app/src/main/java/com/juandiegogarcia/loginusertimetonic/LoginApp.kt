package com.juandiegogarcia.loginusertimetonic

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





