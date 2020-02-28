sealed class BuildType(val buildTypeName: String) {

    abstract val isMinifyEnabled: Boolean

    object BuildTypeDebug : BuildType("debug") {
        override val isMinifyEnabled = false
    }

    object BuildTypeRelease : BuildType("release") {
        override val isMinifyEnabled = true
    }
}


