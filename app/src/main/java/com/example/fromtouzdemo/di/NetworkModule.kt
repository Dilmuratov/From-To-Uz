package com.example.fromtouzdemo.di

import com.example.fromtouzdemo.data.local.BodyDao
import com.example.fromtouzdemo.data.local.BodyDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single<BodyDao> {
        get<BodyDataBase>().getBodyDao()
    }
}