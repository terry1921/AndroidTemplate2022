import com.mx.rockstar.mytemplate.Configuration

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
}

android {
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
    }
}

dependencies {
    // modules

    // unit test
    implementation(libs.coroutines)
    implementation(libs.coroutines.test)
    implementation(libs.junit)
}