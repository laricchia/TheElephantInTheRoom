plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.roblar.theelephantintheroom"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.roblar.theelephantintheroom"
        minSdk = 29
        targetSdk = 33
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
    // Deprecated packagingOptions
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (AppDependency.androidXCore)
    implementation (platform(AppDependency.kotlinBom))
    implementation (AppDependency.androidXLifecycle)
    implementation (AppDependency.androidXActivityCompose)
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

    implementation(project(AppDependency.homepageModule))
}
