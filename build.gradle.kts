import io.gitlab.arturbosch.detekt.Detekt

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:${libs.versions.google.services.get()}")
    }
}
@Suppress("DSL_SCOPE_VIOLATION")// Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.android.kotlin).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.hilt).apply(false)
    alias(libs.plugins.ktlint).apply(false)
    alias(libs.plugins.detekt).apply(false)
}
subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // code style, format
    apply(plugin = "io.gitlab.arturbosch.detekt") // code smell, naming

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}
//Workaround for "Expecting an expression" build error
println("")