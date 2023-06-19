plugins {
    id("kyawlinnthant.application")
    id("kyawlinnthant.hilt")
}

android {
    namespace = "com.kyawlinnthant.auth.domain"
}

dependencies {
    api(project(":feature:auth:data"))
}