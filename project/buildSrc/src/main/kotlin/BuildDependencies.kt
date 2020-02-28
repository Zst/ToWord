import org.gradle.api.artifacts.dsl.DependencyHandler
import util.androidTestImplementation
import util.testImplementation

object BuildDependenciesVersions {
    // Core
    const val KOTLIN = "1.3.61"
    const val APPCOMPAT = "1.1.0"
    const val COROUTINES = "1.3.3"
    const val DAGGER = "2.26"
    const val CORE_KTX = "1.2.0"

    // Arch
    const val NAVIGATION = "2.2.1"
    const val LIFECYCLE = "2.2.0"

    // UI
    const val RECYCLER_VIEW = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val FRAGMENT_KTX = "1.2.2"

    // Tools
    const val ROOM = "2.2.4"
    const val TIMBER = "4.7.1"

    // Tests
    const val TEST = "1.2.0"
    const val TEST_EXT = "1.1.1"
    const val JUNIT = "4.12"
    const val MOCKITO = "2.2.0"
    const val ESPRESSO = "3.2.0"
}

object BuildDependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"

    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"

    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLER_VIEW}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT_KTX}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAINT_LAYOUT}"

    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"

    const val APT_DAGGER = "com.google.dagger:dagger-compiler:${BuildDependenciesVersions.DAGGER}"
    const val APT_ROOM = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM}"

    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT}"
    const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${BuildDependenciesVersions.MOCKITO}"
    const val EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.TEST_EXT}"
    const val CORE = "androidx.test:core:${BuildDependenciesVersions.TEST}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST}"
    const val RULES = "androidx.test:rules:${BuildDependenciesVersions.TEST}"
}

fun DependencyHandler.addTestsDependencies() {
    testImplementation(BuildDependencies.JUNIT)
    testImplementation(BuildDependencies.MOCKITO)
    testImplementation(BuildDependencies.RULES)
    testImplementation(BuildDependencies.RUNNER)
    testImplementation(BuildDependencies.EXT)

    androidTestImplementation(BuildDependencies.MOCKITO)
    androidTestImplementation(BuildDependencies.ESPRESSO)
    androidTestImplementation(BuildDependencies.RUNNER)
    androidTestImplementation(BuildDependencies.RULES)
    androidTestImplementation(BuildDependencies.JUNIT)
}

