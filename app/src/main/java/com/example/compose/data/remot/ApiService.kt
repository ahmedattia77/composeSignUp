package com.example.compose.data.remot

import com.example.compose.data.model.registeration.RegisterationResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
 //https://insta-integration.appssquare.com/api/registeration-data
 @GET("registeration-data")
 suspend fun getRegisterationData()
    :Response<RegisterationResponse>

}