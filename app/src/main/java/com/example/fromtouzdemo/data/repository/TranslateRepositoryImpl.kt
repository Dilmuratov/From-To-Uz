package com.example.fromtouzdemo.data.repository

import android.util.Log
import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.data.models.ResponseData
import com.example.fromtouzdemo.domain.TranslateRepository
import com.example.fromtouzdemo.data.network.TranslateApi
import com.example.fromtouzdemo.utils.baseUrl
import com.example.fromtouzdemo.utils.logTag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TranslateRepositoryImpl : TranslateRepository {

    private var api: TranslateApi

    override suspend fun translate(requestData: RequestData): Flow<ResponseData> =
        flow {
            val response = api.translate(requestData)
            if (response.isSuccessful) {
                emit(response.body()!!)
            } else {
                Log.d(logTag, response.errorBody().toString())
            }
            Log.d(logTag, response.message())
        }.catch { it.printStackTrace() }

    override suspend fun transliterate(requestData: RequestData): Flow<ResponseData> =
        flow {
            val response = api.transliterate(requestData)
            if (response.isSuccessful) {
                emit(response.body()!!)
            } else {
                Log.d(logTag, response.errorBody().toString())
            }
            Log.d(logTag, response.message())
        }.catch { it.printStackTrace() }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()

        api = retrofit.create(TranslateApi::class.java)
    }
}