plugins {
    id("kyawlinnthant.library")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.auth.data"
}

dependencies {
    api(project(":core:firebase"))
    api(project(":core:pref"))
}