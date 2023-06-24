package com.example.fromtouzdemo.data.repository

import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.data.local.BodyDao
import com.example.fromtouzdemo.domain.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryRepositoryImpl(private val dao: BodyDao) : HistoryRepository {

    override suspend fun getAllBodies(): Flow<List<Body>> = flow {
        emit(dao.getAllBodies())
    }

    override suspend fun addBody(body: Body) = dao.addBody(body)

    override suspend fun deleteBody(body: Body) = dao.deleteBody(body)

}