package com.mx.rockstar.mytemplate.core.data.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    @WorkerThread
    fun fetchData(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<String>

}