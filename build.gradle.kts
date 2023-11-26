// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(AppPlugin.androidApp) version Versions.gradleAndroid apply false
    id(AppPlugin.androidLib) version Versions.gradleAndroid apply false
    id(AppPlugin.kotlinAndroid) version Versions.KotlinVersion apply false
}