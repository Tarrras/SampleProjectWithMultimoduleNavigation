plugins {
    alias(libs.plugins.example.android.library)
    alias(libs.plugins.example.android.library.compose)
}

android {
    namespace = "com.example.core_design"
}

dependencies {
    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}