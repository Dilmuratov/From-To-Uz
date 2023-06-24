package com.example.fromtouzdemo.domain.historyusecases.getallbodiesusecase

import com.example.fromtouzdemo.data.local.Body
import kotlinx.coroutines.flow.Flow

interface GetAllBodiesUseCase {

    suspend fun execute(): Flow<List<Body>>

}