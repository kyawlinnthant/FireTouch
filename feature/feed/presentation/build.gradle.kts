plugins {
    id("kyawlinnthant.library")
    id("kyawlinnthant.compose.library")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.feed.presentation"
}

dependencies {
    implementation(project(":feature:feed:domain"))
    api(project(":core:navigation"))
    api(project(":core:theme"))
    api(libs.bundles.androidx.compose)
    api(libs.bundles.androidx.core)
    api(libs.coil)
    debugApi(libs.bundles.androidx.compose.debug)
}