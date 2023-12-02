pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("catalog") {
            from(files("./gradle/libs.versions.toml"))
        }
    }
}
rootProject.name = "TheElephantInTheRoom"
include(":app")
include(":compose:homepage")
