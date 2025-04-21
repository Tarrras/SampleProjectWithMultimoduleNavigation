plugins {
    alias(libs.plugins.example.android.library)
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.core_navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)
}