import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

object AppDependencies {

    private const val ktx = "androidx.core:core-ktx:${Version.ktx}"
    private const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlin_coroutines}"

    const val gson = "com.google.code.gson:gson:${Version.gson}"

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandlerScope.commonDependencies() {
        "implementation"(ktx)
        "implementation"(kotlin_coroutines)
        impTester()
    }

    fun Project.androidProject() {
        dependencies {
            commonDependencies()
        }
    }

    private fun DependencyHandler.impTester() {
        this.add("testImplementation", "junit:junit:4.12")
        this.add("androidTestImplementation", "androidx.test.ext:junit-ktx:1.1.3")
        this.add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.4.0")
    }

    val paged = arrayListOf<String>().apply {
        add("androidx.paging:paging-compose:1.0.0-alpha15")
        add("androidx.paging:paging-runtime:3.1.1")
    }
}
