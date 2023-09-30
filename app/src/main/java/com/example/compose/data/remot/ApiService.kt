package com.example.compose.data.remot

import com.example.compose.data.model.ApplicationResponse
import com.example.compose.data.model.registeration.Data
import com.example.compose.data.model.registeration.RegisterationResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

 @GET("registeration-data")
 suspend fun getRegisterationData()
    :Response<RegisterationResponse>

}