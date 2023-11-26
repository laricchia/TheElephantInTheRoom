import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

internal const val implementation = "implementation"
internal const val testImplementation = "testImplementation"
internal const val androidTestImplementation = "androidTestImplementation"
internal const val debugImplementation = "debugImplementation"

fun DependencyHandlerScope.addAppModules() {
    implementation(project(AppDependency.homepageModule))
}

fun DependencyHandlerScope.addCommonLibraries() {
    implementation (AppDependency.androidXCore)
    implementation (platform(AppDependency.kotlinBom))
    implementation (AppDependency.androidXLifecycle)
}

fun DependencyHandlerScope.addCompose(includeTest: Boolean = true) {
    implementation(platform(AppDependency.composeBom))
    implementation(AppDependency.composeUi)
    implementation(AppDependency.composeUiGraphics)
    implementation(AppDependency.composeUiToolingPreview)
    implementation(AppDependency.composeMaterial3)
    implementation (AppDependency.androidXActivityCompose)

    if (includeTest) {
        androidTestImplementation(platform(AppDependency.composeBom))
        androidTestImplementation(AppDependency.composeJUnit)
        debugImplementation(AppDependency.composeUiTooling)
        debugImplementation(AppDependency.composeUiTestManifest)
    }
}

fun DependencyHandlerScope.addTestBase() {
    testImplementation (AppDependency.jUnit)
}

fun DependencyHandlerScope.addAndroidTestBase() {
    androidTestImplementation (AppDependency.jUnitExt)
    androidTestImplementation (AppDependency.espressoCore)
}
