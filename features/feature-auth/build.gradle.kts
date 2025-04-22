plugins {
    alias(libs.plugins.example.android.feature)
    alias(libs.plugins.example.android.library.compose)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.feature_auth"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}