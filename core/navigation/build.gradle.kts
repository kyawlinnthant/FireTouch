plugins {
    id("kyawlinnthant.library")
    id("kyawlinnthant.compose.library")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.navigation"
}

dependencies {
    api(libs.bundles.androidx.compose)
    api(libs.hilt.navigation)
}