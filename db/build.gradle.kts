import AppDependencies.androidProject

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    kapt {
        generateStubs = true
    }


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
    implementation (AppDependencies.gson)

    val roomVersion = "2.5.0-alpha02"

    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$roomVersion")

    val paging_version = "3.1.1"

    implementation("androidx.paging:paging-runtime:$paging_version")

    // optional - Jetpack Compose integration
    implementation("androidx.paging:paging-compose:1.0.0-alpha15")
}