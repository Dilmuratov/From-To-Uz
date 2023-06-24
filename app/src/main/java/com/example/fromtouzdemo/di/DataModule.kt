package com.example.fromtouzdemo.di

import androidx.room.Room
import com.example.fromtouzdemo.data.local.BodyDataBase
import com.example.fromtouzdemo.data.repository.HistoryRepositoryImpl
import com.example.fromtouzdemo.data.repository.TranslateRepositoryImpl
import com.example.fromtouzdemo.domain.HistoryRepository
import com.example.fromtouzdemo.domain.TranslateRepository
import com.example.fromtouzdemo.domain.historyusecases.addbodyusecase.AddBodyUseCase
import com.example.fromtouzdemo.domain.historyusecases.addbodyusecase.AddBodyUseCaseImpl
import com.example.fromtouzdemo.domain.historyusecases.deletebodyusecase.DeleteBodyUseCase
import com.example.fromtouzdemo.domain.historyusecases.deletebodyusecase.DeleteBodyUseCaseImpl
import com.example.fromtouzdemo.domain.historyusecases.getallbodiesusecase.GetAllBodiesUseCase
import com.example.fromtouzdemo.domain.historyusecases.getallbodiesusecase.GetAllBodiesUseCaseImpl
import com.example.fromtouzdemo.domain.translateusecases.translateusecase.TranslateUseCase
import com.example.fromtouzdemo.domain.translateusecases.translateusecase.TranslateUseCaseImpl
import com.example.fromtouzdemo.domain.translateusecases.transliterateusecase.TransliterateUseCase
import com.example.fromtouzdemo.domain.translateusecases.transliterateusecase.TransliterateUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<TranslateRepository> {
        TranslateRepositoryImpl()
    }

    factory<TranslateUseCase> {
        TranslateUseCaseImpl(get())
    }

    factory<TransliterateUseCase> {
        TransliterateUseCaseImpl(get())
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl(get())
    }

    factory<GetAllBodiesUseCase> {
        GetAllBodiesUseCaseImpl(get())
    }

    factory<AddBodyUseCase> {
        AddBodyUseCaseImpl(get())
    }

    factory<DeleteBodyUseCase> {
        DeleteBodyUseCaseImpl(get())
    }


    single<BodyDataBase> {
        Room.databaseBuilder(
            androidContext(), BodyDataBase::class.java, BodyDataBase.databaseName
        ).fallbackToDestructiveMigration().build()
    }
}