package com.example.fromtouzdemo.presentation.translate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.domain.translateusecases.translateusecase.TranslateUseCase
import com.example.fromtouzdemo.domain.translateusecases.transliterateusecase.TransliterateUseCase

class TranslateViewModelImpl(
    private val translateUseCase: TranslateUseCase,
    private val transliterateUseCase: TransliterateUseCase
) : TranslateViewModel() {

    private val _liveData = MutableLiveData<String>()
    override val liveData: LiveData<String>
        get() = _liveData

    override suspend fun translate(requestData: RequestData) {
        translateUseCase.execute(requestData).collect {
            _liveData.value = it
        }
    }

    override suspend fun transliterate(requestData: RequestData) {
        transliterateUseCase.execute(requestData).collect {
            _liveData.value = it
        }
    }
}