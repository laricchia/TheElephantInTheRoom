plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.roblar.homepage"
    compileSdk = AppConfiguration.compileSdk

    defaultConfig {
        minSdk = AppConfiguration.DefaultConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfiguration.CompileOptions.sourceCompatibility
        targetCompatibility = AppConfiguration.CompileOptions.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = AppConfiguration.KotlinOptions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =
            AppConfiguration.ComposeOption.kotlinCompilerExtensionVersion
    }
}

dependencies {
    addCommonLibraries()
    addCompose()
    addTestBase()
    addAndroidTestBase()
}