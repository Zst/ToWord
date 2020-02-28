plugins {
    id("plugins.android-dynamic-feature")
}

dependencies {
    implementation(project(BuildModules.Features.HOME))

    implementation(BuildDependencies.RECYCLER_VIEW)
}