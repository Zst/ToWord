package plugins

import BuildAndroidConfig
import BuildDependencies
import addTestsDependencies

plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
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
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
}

dependencies {
    implementation(project(BuildModules.APP))
    implementation(project(BuildModules.CORE))
    implementation(project(BuildModules.Common.UI))

    implementation(BuildDependencies.KOTLIN)
    implementation(BuildDependencies.APPCOMPAT)
    implementation(BuildDependencies.COROUTINES)
    implementation(BuildDependencies.COROUTINES_ANDROID)
    implementation(BuildDependencies.NAVIGATION_FRAGMENT)
    implementation(BuildDependencies.NAVIGATION_UI)
    implementation(BuildDependencies.LIFECYCLE_EXTENSIONS)
    implementation(BuildDependencies.LIFECYCLE_VIEWMODEL)
    implementation(BuildDependencies.CORE_KTX)
    implementation(BuildDependencies.FRAGMENT_KTX)
    implementation(BuildDependencies.CONSTRAINT_LAYOUT)
    implementation(BuildDependencies.DAGGER)
    implementation(BuildDependencies.TIMBER)

    kapt(BuildDependencies.APT_DAGGER)
    kapt(BuildDependencies.APT_ROOM)

    addTestsDependencies()
}
