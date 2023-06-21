@file: Suppress("UnstableApiUsage")

import io.gitlab.arturbosch.detekt.Detekt

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
detekt {
    parallel = true
    allRules = true
    autoCorrect = true
    buildUponDefaultConfig = true
    source.setFrom(files(projectDir))
    config.setFrom(file("${rootProject.rootDir}/config/detekt/detekt.yml"))

    tasks.withType<Detekt>().configureEach {
        include("**/*.kt", "**/*.kts")
        exclude("**/build/**")

        jvmTarget = JavaVersion.VERSION_17.toString()

        reports {
            txt.required.set(false)
            sarif.required.set(false)
            md.required.set(false)
            html.required.set(true)
            html.outputLocation.set(file("${project.buildDir}/reports/detekt/detekt.html"))
            xml.required.set(true)
            xml.outputLocation.set(file("${project.buildDir}/reports/detekt/detekt.xml")) // It's required for Sonar
        }
    }
}

dependencies {

    implementation(project(":feature:auth:presentation"))
    implementation(project(":feature:feed:presentation"))
    implementation(libs.splashscreen)
    implementation(libs.multidex)
}