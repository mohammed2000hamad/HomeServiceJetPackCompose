package com.and.dev.homeservice.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.and.dev.homeservice.apiService.ApiService
import com.and.dev.homeservice.model.OrderRequestData
import com.and.dev.homeservice.model.PreferenceManager
import kotlinx.coroutines.launch

class GetUnCompleteOrders : ViewModel() {

    var listUnCompleteOrderLiveData: List<OrderRequestData> by mutableStateOf(listOf())


    fun getUnCompleteOrders(token:String) {
        viewModelScope.launch {
            val apiService = ApiService.geInstance()
            val getUnComplete = apiService.getUnCompletedOrder(token)

            listUnCompleteOrderLiveData = getUnComplete.data


        }


    }
}