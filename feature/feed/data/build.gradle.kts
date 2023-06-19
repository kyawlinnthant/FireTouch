plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.feed.data"
}

dependencies {
    api(project(":core:firebase"))
    api(project(":core:pref"))
}