package com.example.fromtouzdemo.domain.historyusecases.addbodyusecase

import com.example.fromtouzdemo.data.local.Body

interface AddBodyUseCase {

    suspend fun execute(body: Body)

}