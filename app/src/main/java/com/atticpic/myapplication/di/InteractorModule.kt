package com.atticpic.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import interactor.LoginInteractor
import interactor.LoginInteractorImpl

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    fun provideLoginInteractor(): LoginInteractor =
        LoginInteractorImpl()
}
