package com.example.fromtouzdemo.domain.historyusecases.addbodyusecase

import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.domain.HistoryRepository

class AddBodyUseCaseImpl(private val historyRepository: HistoryRepository) : AddBodyUseCase {

    override suspend fun execute(body: Body) = historyRepository.addBody(body)

}