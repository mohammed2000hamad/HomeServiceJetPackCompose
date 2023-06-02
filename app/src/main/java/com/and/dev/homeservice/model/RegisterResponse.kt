package com.and.dev.homeservice.model

data class RegisterResponse(
    val code: Int,
    val success: Boolean,
    val message: String,
    val data: UserData
)