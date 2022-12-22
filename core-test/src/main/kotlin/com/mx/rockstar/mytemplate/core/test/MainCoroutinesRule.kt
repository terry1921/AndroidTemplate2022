@file:Suppress("SpellCheckingInspection")
@file:OptIn(ExperimentalCoroutinesApi::class)

package com.mx.rockstar.mytemplate.core.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutinesRule(
  val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {

  val testScope = TestScope(testDispatcher)

  override fun starting(description: Description) {
    Dispatchers.setMain(testDispatcher)
  }

  override fun finished(description: Description) {
    super.finished(description)
    Dispatchers.resetMain()
  }
}
