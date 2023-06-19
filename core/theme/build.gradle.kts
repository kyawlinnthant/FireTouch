plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.compose")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.theme"
}

dependencies {
    api(libs.bundles.androidx.compose)
    api(libs.hilt.navigation)
}