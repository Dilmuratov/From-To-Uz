package com.example.fromtouzdemo.di

import com.example.fromtouzdemo.presentation.history.HistoryViewModel
import com.example.fromtouzdemo.presentation.translate.TranslateViewModel
import com.example.fromtouzdemo.presentation.translate.TranslateViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<TranslateViewModel> {
        TranslateViewModelImpl(
            translateUseCase = get(),
            transliterateUseCase = get()
        )
    }

    viewModel<HistoryViewModel> {
        HistoryViewModel(
            getAllBodiesUseCase = get(),
            addBodyUseCase = get(),
            deleteBodyUseCase = get()
        )
    }
}