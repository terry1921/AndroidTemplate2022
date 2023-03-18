package com.mx.rockstar.mytemplate.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.mx.rockstar.mytemplate.R
import com.mx.rockstar.mytemplate.databinding.LayoutMainBinding
import com.skydoves.bindables.BindingActivity
import com.skydoves.transformationlayout.onTransformationStartContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<LayoutMainBinding>(R.layout.layout_main) {

    @get:VisibleForTesting
    internal val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        binding {
            vm = viewModel
        }
    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener {
            viewModel.updateMessage()
        }
    }
}