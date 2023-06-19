plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.feed.domain"
}

dependencies {
    api(project(":feature:feed:data"))
}