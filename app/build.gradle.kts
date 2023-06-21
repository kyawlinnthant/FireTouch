@file: Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.compose.application")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.firetouch"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.kyawlinnthant.firetouch"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z ( Major.Minor.Patch)
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

ktlint {
    version.set(libs.versions.ktlintVersion.get())
    android.set(true)
    verbose.set(true)
    ignoreFailures.set(true)
    outputColorName.set("RED")
    reporters {
        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.JSON)
        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
    }
    filter {
        exclude("**/generated/**")
        include("**/*.kt", "**/*.kts")
    }
}

dependencies {

    implementation(project(":feature:auth:presentation"))
    implementation(project(":feature:feed:presentation"))
    implementation(libs.splashscreen)
    implementation(libs.multidex)
}