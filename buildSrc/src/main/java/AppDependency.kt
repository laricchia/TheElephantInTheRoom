object AppDependency {

    const val homepageModule = ":compose:homepage"

    const val androidXCore = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidXLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifecycleRuntime}"
    const val androidXActivityCompose = "androidx.activity:activity-compose:${Versions.ComposeActivity}"


    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"

    // Bom - use with platform
    const val composeBom ="androidx.compose:compose-bom:${Versions.ComposeBom}"
    const val kotlinBom ="org.jetbrains.kotlin:kotlin-bom:${Versions.KotlinVersion}"


    // Test implementation
    const val jUnit = "junit:junit:${Versions.JUnitVersion}"

    // Android test implementation
    const val jUnitExt = "androidx.test.ext:junit:${Versions.JUnitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.EspressoCore}"
    const val composeJUnit = "androidx.compose.ui:ui-test-junit4"

    // Debug implementation
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
}
