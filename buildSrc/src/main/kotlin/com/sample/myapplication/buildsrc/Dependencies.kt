package com.sample.myapplication.buildsrc

object Versions {
    const val versionCode: Int = 1
    const val versionName = "1.0.0"

    const val sdk = 33
    const val minSdk = 21
    const val buildTools = "33.0.0"
    const val kotlin = "1.8.0"
    const val hilt = "2.44"
    const val okhttp = "4.9.3"
}

object Plugins {
    const val android = "com.android.tools.build:gradle:7.3.1"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val dagger_hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object Libs {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

        //Coroutine
        object Coroutines {
            private const val version = "1.3.9"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
        const val core = "androidx.core:core-ktx:1.5.0"
        const val multidex = "androidx.multidex:multidex:2.0.1"

        const val appcompat = "androidx.appcompat:appcompat:1.3.1"

        object Compose {
            const val version = "1.4.0"

            const val bom = "androidx.compose:compose-bom:2023.01.00"
            const val runtime = "androidx.compose.runtime:runtime"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata"
            const val material2 = "androidx.compose.material:material"
            const val material3 = "androidx.compose.material3:material3"
            const val material3WindowSize = "androidx.compose.material3:material3-window-size-class"
            const val foundation = "androidx.compose.foundation:foundation"
            const val layout = "androidx.compose.foundation:foundation-layout"
            const val tooling = "androidx.compose.ui:ui-tooling"
            const val animation = "androidx.compose.animation:animation"
            const val coil = "io.coil-kt:coil-compose:2.0.0-rc01"
            const val materialIcons = "androidx.compose.material:material-icons-core:1.1.1"
            const val materialIconsExt = "androidx.compose.material:material-icons-extended:1.1.1"

            const val uiTest = "androidx.compose.ui:ui-test:$version"
            const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"

        }

        object Lifecycle {
            private const val version = "2.6.1"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.6.0-alpha09"
            const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        }

        object Test {
            private const val version = "1.5.0"
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"
            object Ext {
                private const val version = "1.1.5"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
            const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }

    //Dagger - Hilt
    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val testing = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    //Retrofit
    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-gson:$version"
    }
    //OkHttp
    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor"

    }

    //Unit test
    object UnitTest {
        const val junit = "junit:junit:4.13"
        const val mockk = "io.mockk:mockk:1.12.0"
    }
}