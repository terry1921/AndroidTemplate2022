package com.mx.rockstar.mytemplate.core.data.di

import com.mx.rockstar.mytemplate.core.data.repository.MainRepository
import com.mx.rockstar.mytemplate.core.data.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

}