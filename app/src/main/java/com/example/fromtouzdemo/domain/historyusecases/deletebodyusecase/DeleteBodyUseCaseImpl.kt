package com.example.fromtouzdemo.domain.historyusecases.deletebodyusecase

import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.domain.HistoryRepository

class DeleteBodyUseCaseImpl(private val historyRepository: HistoryRepository) : DeleteBodyUseCase {

    override suspend fun execute(body: Body) = historyRepository.deleteBody(body)

}