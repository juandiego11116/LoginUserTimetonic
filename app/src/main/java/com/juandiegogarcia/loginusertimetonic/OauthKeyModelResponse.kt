package com.juandiegogarcia.loginusertimetonic

// Data class representing the response model for an OAuth key creation.
data class OauthKeyModelResponse(
    val status: String,
    val oauthkey: String,
    val id: String,
    val o_u: String,
    val createdVNB: String,
    val req: String
)
