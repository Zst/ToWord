import util.implementation

plugins {
    id("plugins.android-library")
}

dependencies {
    implementation(project(BuildModules.Common.UI))

    implementation(BuildDependencies.CONSTRAINT_LAYOUT)
    implementation(BuildDependencies.FRAGMENT_KTX)
}
