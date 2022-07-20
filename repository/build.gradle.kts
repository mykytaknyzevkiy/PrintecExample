import AppDependencies.androidProject
import AppDependencies.implementation

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = (Version.compileSdk)
    buildToolsVersion = (Version.buildTool)

    defaultConfig {
        minSdkPreview = (Config.minSdkVersion)
        targetSdk =  (Config.targetVersion.toInt())
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

androidProject()

dependencies {
    implementation (project(":network"))
    implementation (project(":db"))

    implementation (AppDependencies.paged)
}