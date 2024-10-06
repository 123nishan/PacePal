import com.nishan.convention.addUiLayerDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies


class AndroidFeatureUiConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("pacepal.android.library.compose")
                apply(plugin = "org.jetbrains.kotlin.plugin.compose")
            }

            dependencies {
               addUiLayerDependencies(target)

            }

        }
    }
}