package com.example.fromtouzdemo.domain.translateusecases.translateusecase

import com.example.fromtouzdemo.data.models.RequestData
import kotlinx.coroutines.flow.Flow

interface TranslateUseCase {

    suspend fun execute(requestData: RequestData): Flow<String>

}