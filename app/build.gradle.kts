plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.roblar.theelephantintheroom"
    compileSdk = AppConfiguration.compileSdk

    defaultConfig {
        applicationId = "com.roblar.theelephantintheroom"
        minSdk = AppConfiguration.DefaultConfig.minSdk
        targetSdk = AppConfiguration.DefaultConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            // Variable name change: minifyEnabled = false
            isMinifyEnabled = false

            // Function invocation:
            //  proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
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
    // Deprecated packagingOptions
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    addCommonLibraries()
    addCompose(includeTest = false)
    addTestBase()
    addAndroidTestBase()
    addAppModules()
}
