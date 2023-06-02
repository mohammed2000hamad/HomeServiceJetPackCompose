package com.and.dev.homeservice.model

data class LoginResponse(
    val code: Int,
    val success: Boolean,
    val message: String,
    val data: UserData
)