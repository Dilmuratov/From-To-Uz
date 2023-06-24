package com.example.fromtouzdemo.domain.historyusecases.getallbodiesusecase

import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.domain.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllBodiesUseCaseImpl(private val historyRepository: HistoryRepository) :
    GetAllBodiesUseCase {

    override suspend fun execute(): Flow<List<Body>> = flow {
        historyRepository.getAllBodies().collect {
            emit(it)
        }
    }

}