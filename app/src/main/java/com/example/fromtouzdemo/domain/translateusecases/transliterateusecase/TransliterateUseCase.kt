package com.example.fromtouzdemo.domain.translateusecases.transliterateusecase

import com.example.fromtouzdemo.data.models.RequestData
import kotlinx.coroutines.flow.Flow

interface TransliterateUseCase {

    suspend fun execute(requestData: RequestData): Flow<String>

}