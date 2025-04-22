import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.implementation
import utils.libs
import utils.libsDependency

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "example.android.library")

            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true

                buildFeatures {
                    // Enables Jetpack Compose for this module
                    compose = true
                }
            }

            dependencies {
                implementation(libsDependency("androidx.navigation.compose"))
                implementation(project(":core:core-navigation"))
                implementation(project(":core:core-design"))
            }
        }
    }
}
