package com.example.fromtouzdemo.presentation.translate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fromtouzdemo.data.models.RequestData

abstract class TranslateViewModel: ViewModel() {

    abstract val liveData: LiveData<String>

    abstract suspend fun translate(requestData: RequestData)

    abstract suspend fun transliterate(requestData: RequestData)
}