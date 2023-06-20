plugins {
    id("kyawlinnthant.library")
    id("kyawlinnthant.hilt")
    id("kyawlinnthant.firebase")
}

android {
    namespace = "com.kyawlinnthant.firetouch.firebase"
}

dependencies {
    api(project(":core:model"))
    api(project(":core:common"))
    api(libs.bundles.firebase)
}