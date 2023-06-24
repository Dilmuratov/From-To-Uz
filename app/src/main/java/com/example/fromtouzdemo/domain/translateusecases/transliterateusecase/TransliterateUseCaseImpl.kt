package com.example.fromtouzdemo.domain.translateusecases.transliterateusecase

import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.domain.TranslateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TransliterateUseCaseImpl(private val translateRepository: TranslateRepository) :
    TransliterateUseCase {

    override suspend fun execute(requestData: RequestData): Flow<String> = flow {
        translateRepository.transliterate(requestData).collect {
            emit(it.result)
        }
    }
}