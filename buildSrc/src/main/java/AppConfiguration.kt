import org.gradle.api.JavaVersion

object AppConfiguration {

    const val compileSdk = 34

    object DefaultConfig {
        const val minSdk = 29
        const val targetSdk = 34
    }

    object CompileOptions {
        val sourceCompatibility = JavaVersion.VERSION_1_8
        val targetCompatibility = JavaVersion.VERSION_1_8
    }

    object KotlinOptions {
        const val jvmTarget = "1.8"
    }

    object ComposeOption {
        const val kotlinCompilerExtensionVersion = "1.3.2"
    }

}