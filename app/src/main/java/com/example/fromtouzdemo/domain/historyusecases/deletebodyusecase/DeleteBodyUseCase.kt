package com.example.fromtouzdemo.domain.historyusecases.deletebodyusecase

import com.example.fromtouzdemo.data.local.Body

interface DeleteBodyUseCase {

    suspend fun execute(body: Body)

}