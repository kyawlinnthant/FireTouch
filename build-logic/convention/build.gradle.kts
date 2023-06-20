plugins {
    `kotlin-dsl`
}

group = "com.kyawlinnthant.firetouch.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}
gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "kyawlinnthant.application"
            implementationClass = "ApplicationPlugin"
        }
        register("androidApplicationCompose") {
            id = "kyawlinnthant.compose.application"
            implementationClass = "ApplicationComposePlugin"
        }
        register("androidDaggerHilt") {
            id = "kyawlinnthant.hilt"
            implementationClass = "HiltPlugin"
        }
        register("androidFirebase"){
            id = "kyawlinnthant.firebase"
            implementationClass = "FirebasePlugin"
        }
        register("androidLibrary"){
            id = "kyawlinnthant.library"
            implementationClass = "LibraryPlugin"
        }
        register("androidLibraryCompose") {
            id = "kyawlinnthant.compose.library"
            implementationClass = "LibraryComposePlugin"
        }
    }
}