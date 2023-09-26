package com.example.compose.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.data.model.registeration.Data
import com.example.compose.data.model.registeration.RegisterationResponse
import com.example.compose.repository.RegistrationRepo
import com.example.compose.utils.ApiStatus
import com.example.compose.utils.getError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RegistrationViewModel :ViewModel() {

    private val _registrationFlow: MutableStateFlow<ApiStatus<RegisterationResponse>>
            = MutableStateFlow(ApiStatus.Empty)
    val registrationFlow: StateFlow<ApiStatus<RegisterationResponse>> = _registrationFlow

    private var _registration = MutableLiveData<RegisterationResponse>()
    val registration = _registration

    private var _errorRegistration = MutableLiveData<String>()
    val errorRegistration = _registration


    init {
//        getRegistrationData()
        getRegistrationDataFlow()
    }

    fun getRegistrationDataFlow () = viewModelScope.launch {
        try {
            RegistrationRepo().getRegistrationDataFlow().collect{
                _registrationFlow.value  = ApiStatus.Success(it)
            }

        }catch (e : IOException){
            e.printStackTrace()
            _registrationFlow.value = ApiStatus.Failure(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            _registrationFlow.value = ApiStatus.Failure(e)
        } catch (e: Exception) {
            e.printStackTrace()
            _registrationFlow.value = ApiStatus.Failure(e)
        }
    }

    fun getRegistrationData (){
        viewModelScope.launch {
            try {
                val res = RegistrationRepo().getRegistrationData()
                if (res.isSuccessful){
                    _registration.postValue(res.body())
                }
                else
                    _errorRegistration.postValue(res.errorBody()?.getError().toString())
            }catch (e : IOException){
                e.printStackTrace()
                _errorRegistration.postValue(e.message.toString())
            } catch (e: HttpException) {
                e.printStackTrace()
                _errorRegistration.postValue(e.response()?.errorBody()?.getError().toString())
            } catch (e: Exception) {
                e.printStackTrace()
                _errorRegistration.postValue(e.message.toString())
            }
        }
    }


}