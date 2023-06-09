package com.and.dev.homeservice.model

data class UserData(
    val id: Int,
    val name: String,
    val email: String,
    val photo: String,
    val phone: String,
    val active: String,
    val token: String
)