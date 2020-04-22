import BuildDependencies
import util.implementation
import util.kapt

plugins {
    id("plugins.android-library")
}

dependencies {
    implementation(BuildDependencies.APPCOMPAT)
    implementation(BuildDependencies.CONSTRAINT_LAYOUT)
    implementation(BuildDependencies.RECYCLER_VIEW)
}
