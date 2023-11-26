import org.gradle.api.JavaVersion

object AppConfiguration {

    const val compileSdk = 34

    object DefaultConfig {
        const val minSdk = 29
        const val targetSdk = 34
    }

    object CompileOptions {
        val sourceCompatibility = JavaVersion.VERSION_1_9
        val targetCompatibility = JavaVersion.VERSION_1_9
    }

    object KotlinOptions {
        const val jvmTarget = "9"
    }

    object ComposeOption {
        // https://developer.android.com/jetpack/androidx/releases/compose-kotlin
        const val kotlinCompilerExtensionVersion = "1.5.4"
    }

}