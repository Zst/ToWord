import BuildDependencies
import util.implementation
import util.kapt

plugins {
    id("plugins.android-library")
}

android {
}

dependencies {
    implementation(BuildDependencies.ROOM)
    implementation(BuildDependencies.ROOM_KTX)
    implementation(BuildDependencies.LIFECYCLE_EXTENSIONS)
    implementation(BuildDependencies.NAVIGATION_UI)
    implementation(BuildDependencies.FRAGMENT_KTX)
    implementation(BuildDependencies.CORE_KTX)

    kapt(BuildDependencies.APT_ROOM)
}
