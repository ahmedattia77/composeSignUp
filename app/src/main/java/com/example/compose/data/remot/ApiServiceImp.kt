package com.example.compose.data.remot

import com.example.compose.data.model.ApplicationResponse
import com.example.compose.data.model.registeration.Data
import com.example.compose.data.model.registeration.RegisterationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) {
    suspend fun getSignUpData () : Flow<RegisterationResponse>{
        return flow {
            val response = apiService.getRegisterationData().body()
            emit(response !!)
        }.flowOn(Dispatchers.IO)
    }
}