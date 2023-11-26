plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.roblar.homepage"
    compileSdk = 33

    defaultConfig {
        minSdk = 29

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {

    implementation (AppDependency.androidXCore)
    implementation (platform(AppDependency.kotlinBom))

    implementation (platform(AppDependency.composeBom))
    implementation (AppDependency.composeUi)
    implementation (AppDependency.composeUiGraphics)
    implementation (AppDependency.composeUiToolingPreview)
    implementation (AppDependency.composeMaterial3)

    testImplementation (AppDependency.jUnit)
    androidTestImplementation (AppDependency.jUnitExt)
    androidTestImplementation (AppDependency.espressoCore)
    androidTestImplementation (platform(AppDependency.composeBom))
    androidTestImplementation (AppDependency.composeJUnit)
    debugImplementation (AppDependency.composeUiTooling)
    debugImplementation (AppDependency.composeUiTestManifest)
}