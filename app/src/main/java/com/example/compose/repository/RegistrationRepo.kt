package com.example.compose.repository

import com.example.compose.data.model.registeration.RegisterationResponse
import com.example.compose.data.remot.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RegistrationRepo {
    private val apiInterface = RetrofitHelper.getInstance().create(ApiService::class.java)
    suspend fun getRegistrationData()
            = apiInterface.getRegisterationData()

    suspend fun getRegistrationDataFlow() : Flow<RegisterationResponse> {
        return flow {
            val data = apiInterface.getRegisterationData().body()
            emit(data !!)
        }.flowOn(Dispatchers.IO)
    }

}
object RetrofitHelper {

     private const val baseUrl = "https://insta-integration.appssquare.com/api/"
     fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
     }
}