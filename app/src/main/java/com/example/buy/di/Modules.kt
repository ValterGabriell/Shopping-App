package com.example.buy.di

import com.example.buy.Repository.EditarActivityRepository
import com.example.buy.Repository.MainActivityRepository
import com.example.buy.Repository.NewProdutoActivityRepository
import com.example.buy.viewmodel.EditarDeleteViewModel
import com.example.buy.viewmodel.MainActivityViewModel
import com.example.buy.viewmodel.NovoProtudoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { EditarActivityRepository() }
    single { MainActivityRepository() }
    single { NewProdutoActivityRepository() }
}


val viewModelModule = module {
    viewModel { EditarDeleteViewModel(get(), androidApplication()) }
    viewModel { MainActivityViewModel(get(), androidApplication()) }
    viewModel { NovoProtudoViewModel(get(), androidApplication()) }
}