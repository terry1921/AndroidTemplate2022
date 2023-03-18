package com.mx.rockstar.mytemplate.core.data.repository

import androidx.annotation.VisibleForTesting
import androidx.annotation.WorkerThread
import com.mx.rockstar.mytemplate.core.network.AppDispatcher
import com.mx.rockstar.mytemplate.core.network.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@VisibleForTesting
class MainRepositoryImpl @Inject constructor(
    @Dispatcher(AppDispatcher.IO) private val ioDispatcher: CoroutineDispatcher
) : MainRepository {

    @WorkerThread
    override fun fetchData(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<String> = flow {
        kotlinx.coroutines.delay(1000)
        if (page == 0) emit("Comenzamos...")
        else if (page <= 10) emit("Flujo #${page} Terminando")
        else onError("Ya son Muchas...")
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)

}