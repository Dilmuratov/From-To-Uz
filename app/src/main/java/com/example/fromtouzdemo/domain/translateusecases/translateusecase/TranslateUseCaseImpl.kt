package com.example.fromtouzdemo.domain.translateusecases.translateusecase

import com.example.fromtouzdemo.data.models.BodyData
import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.domain.TranslateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class TranslateUseCaseImpl(private val translateRepository: TranslateRepository) :
    TranslateUseCase {

    override suspend fun execute(requestData: RequestData): Flow<String> = flow {
        translateRepository.translate(requestData).collect {
            emit(it.result)
        }
    }.catch { it.printStackTrace() }

}