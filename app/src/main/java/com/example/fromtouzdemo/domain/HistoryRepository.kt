package com.example.fromtouzdemo.domain

import com.example.fromtouzdemo.data.local.Body
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun getAllBodies(): Flow<List<Body>>

    suspend fun addBody(body: Body)

    suspend fun deleteBody(body: Body)
}