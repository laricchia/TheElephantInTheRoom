import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

internal const val implementation = "implementation"
internal const val testImplementation = "testImplementation"
internal const val androidTestImplementation = "androidTestImplementation"
internal const val debugImplementation = "debugImplementation"

fun DependencyHandlerScope.addAppModules() {
    implementation(project(AppDependency.homepageModule))
}
