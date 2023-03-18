package com.mx.rockstar.mytemplate.ui.main

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.mx.rockstar.mytemplate.core.data.repository.MainRepository
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BindingViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(false)
        private set

    @get:Bindable
    var message: String? by bindingProperty(null)
        private set

    init {
        Timber.d("init MainViewModel")
    }

    private val fetchingIndex: MutableStateFlow<Int> = MutableStateFlow(0)
    private val listFlow = fetchingIndex.flatMapLatest { page ->
        mainRepository.fetchData(
            page = page,
            onStart = { isLoading = true },
            onComplete = { isLoading = false },
            onError = { message = it }
        )
    }

    fun updateMessage() {
        if (!isLoading) {
            message = ""
            fetchingIndex.value++
        }
    }

    @get:Bindable
    val response: String by listFlow.asBindingProperty(viewModelScope, "")

}