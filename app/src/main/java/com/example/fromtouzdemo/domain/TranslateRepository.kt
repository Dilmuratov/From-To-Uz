package com.example.fromtouzdemo.domain

import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.data.models.ResponseData
import kotlinx.coroutines.flow.Flow

interface TranslateRepository {

    suspend fun translate(requestData: RequestData): Flow<ResponseData>

    suspend fun transliterate(requestData: RequestData): Flow<ResponseData>

}