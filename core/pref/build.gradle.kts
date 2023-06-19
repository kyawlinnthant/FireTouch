plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.pref"
}

dependencies {
    api(project(":core:dispatchers"))
    implementation(libs.bundles.datastore)
}