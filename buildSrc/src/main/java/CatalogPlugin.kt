import org.gradle.accessors.dm.LibrariesForCatalog
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getPlugin
import org.gradle.kotlin.dsl.the

class CatalogPlugin : Plugin<Project> {
    private var target: Project? = null

    override fun apply(target: Project) {
        this.target = target

        val ext = target.extensions.create<CatalogPluginExtension>("catalogPluginConfiguration")
        ext.addCompose.convention(false)
        ext.addComposeTest.convention(false)
        ext.addCommon.convention(false)
        ext.addTestBase.convention(false)
        ext.addAndroidTestBase.convention(false)

        println("Compose? ${ext.addCompose.get()} Common? ${ext.addCommon.get()}")
    }

    internal fun onReconfigured() {
        target?.extensions?.getByType(CatalogPluginExtension::class)?.let { ext ->
            println("Compose? ${ext.addCompose.get()} Common? ${ext.addCommon.get()}")
            updateImports(ext)
        }
    }

    private fun updateImports(configuration: CatalogPluginExtension) {
        // The suggested and unsafe way:
        //  https://docs.gradle.org/8.5-rc-3/userguide/platforms.html#sub:type-unsafe-access-to-catalog

        target?.the<LibrariesForCatalog>()?.let { catalog ->
            target?.dependencies {
                if (configuration.addCommon.get()) {
                    implementation(platform(catalog.kotlinBom))
                    implementation(catalog.androidXCore)
                    implementation(catalog.androidXLifecycle)
                }

                if (configuration.addCompose.get()) {
                    implementation(platform(catalog.composeBom))
                    implementation(catalog.composeUi)
                    implementation(catalog.composeUiGraphics)
                    implementation(catalog.composeUiToolingPreview)
                    implementation(catalog.composeMaterial3)
                    implementation (catalog.androidXActivityCompose)
                    debugImplementation(catalog.composeUiTooling)
                }

                if (configuration.addComposeTest.get()) {
                    androidTestImplementation(platform(catalog.composeBom))
                    androidTestImplementation(catalog.composeJUnit)
                    debugImplementation(catalog.composeUiTestManifest)
                }

                if (configuration.addTestBase.get()) {
                    testImplementation(catalog.jUnit)
                }

                if (configuration.addAndroidTestBase.get()) {
                    androidTestImplementation(catalog.jUnitExt)
                    androidTestImplementation(catalog.espressoCore)
                }
            }
        }
    }

}

interface CatalogPluginExtension {
    val addCommon: Property<Boolean>
    val addCompose: Property<Boolean>
    val addComposeTest: Property<Boolean>
    val addTestBase: Property<Boolean>
    val addAndroidTestBase: Property<Boolean>
}



fun org.gradle.api.Project.`catalogPlugin`(configure: Action<CatalogPluginExtension>) {
    val ext = project.extensions.getByType(CatalogPluginExtension::class)
    configure.execute(ext)
    project.plugins.getPlugin(CatalogPlugin::class).onReconfigured()
}
