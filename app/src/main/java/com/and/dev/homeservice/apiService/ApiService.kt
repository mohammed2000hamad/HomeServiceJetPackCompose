package com.and.dev.homeservice.apiService

import com.and.dev.homeservice.model.AllWorkResponse
import com.and.dev.homeservice.model.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("all/works")
    suspend fun getAllWorkResponse(): AllWorkResponse

    @FormUrlEncoded
    @POST("auth/login/user")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>


    companion object {
        private const val BASE_URL = "https://studentucas.awamr.com/api/"

        var apiService: ApiService? = null

        fun geInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }


    }

}