package com.juandiegogarcia.loginusertimetonic
// Data class representing the response model for an session key creation.
data class SessionModelResponse(
    val status: String,
    val sesskey: String?,
    val id: String?,
    val restrictions: Restrictions?,
    val appName: String?,
    val createdVNB: String?,
    val req: String?
)

data class Restrictions(
    val carnet_code: String?,
    val carnet_owner: String?,
    val readonly: Boolean,
    val hideTables: Boolean,
    val hideMessages: Boolean,
    val hideEvents: Boolean,
    val internal: Boolean
)
