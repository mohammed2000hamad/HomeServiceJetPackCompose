package com.and.dev.homeservice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.and.dev.homeservice.apiService.ApiService
import com.and.dev.homeservice.model.UserData
import kotlinx.coroutines.launch


class LoginViewModel(private val apiService: ApiService) : ViewModel() {
    private val _loginResult = MutableLiveData<Result<UserData>>()
    val loginResult: LiveData<Result<UserData>> get() = _loginResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = apiService.login(email, password)
                if (response.isSuccessful) {
                    val userData = response.body()?.data
                    if (userData != null) {
                        _loginResult.value = Result.success(userData)
                    } else {
                        _loginResult.value = Result.failure(Exception("Invalid response data"))

                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    _loginResult.value = Result.failure(Exception(errorBody))
                }
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }


}


