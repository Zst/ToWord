package plugins

import BuildAndroidConfig
import BuildDependencies
import addTestsDependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    viewBinding {
        isEnabled = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
    }
}

dependencies {
    implementation(BuildDependencies.KOTLIN)
    implementation(BuildDependencies.COROUTINES)
    implementation(BuildDependencies.COROUTINES_ANDROID)
    implementation(BuildDependencies.DAGGER)
    implementation(BuildDependencies.TIMBER)

    kapt(BuildDependencies.APT_DAGGER)

    addTestsDependencies()
}
