package com.example.fromtouzdemo.data.network

import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.data.models.ResponseData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TranslateApi {

    @POST("api/v1/translate")
    suspend fun translate(@Body requestData: RequestData): Response<ResponseData>

    @POST("/api/v1/transliterate")
    suspend fun transliterate(@Body requestData: RequestData): Response<ResponseData>

}