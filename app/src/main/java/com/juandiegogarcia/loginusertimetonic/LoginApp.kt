package com.juandiegogarcia.loginusertimetonic

suspend fun loginApp(login: String, password: String): Pair<String?, SessionModelResponse?> {
    return try {
        val appKey = appKeyService.getAppKey().body()?.appKey ?: ""
        val oauthKey = createOauthKey(login, password, appKey)
        val sessionResponse = createSessionKey(oauthKey.o_u, oauthKey.oauthkey)
        Pair(oauthKey.o_u,sessionResponse)
    } catch (e: Exception) {
        e.printStackTrace()
        Pair(null, null)
    }
}





