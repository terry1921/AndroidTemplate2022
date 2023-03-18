package com.mx.rockstar.mytemplate.core.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.*

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val appDispatcher: AppDispatcher)

enum class AppDispatcher {
    IO
}