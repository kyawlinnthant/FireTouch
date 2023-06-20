plugins {
    id("kyawlinnthant.library")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.pref"
}

dependencies {
    api(project(":core:dispatchers"))
    implementation(libs.bundles.datastore)
}