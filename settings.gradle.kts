@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        includeBuild("build-logic")
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
}
rootProject.name = "FireTouch"
include(":app")
include(
    ":core:model",
    ":core:common",
    ":core:firebase",
    ":core:navigation",
    ":core:theme",
    ":core:dispatchers",
    ":core:pref",
)
include(
    ":feature:auth:data",
    ":feature:auth:domain",
    ":feature:auth:presentation",
    ":feature:feed:data",
    ":feature:feed:domain",
    ":feature:feed:presentation",
)



