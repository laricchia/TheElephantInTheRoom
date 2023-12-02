plugins {
    alias(catalog.plugins.androidLib)
    alias(catalog.plugins.kotlin)
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

apply<CatalogPlugin>()

catalogPlugin {
    addCommon = true
    addCompose = false
    addTestBase = true
    addAndroidTestBase = true
}
