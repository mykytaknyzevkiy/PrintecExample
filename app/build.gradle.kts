import AppDependencies.androidProject
import AppDependencies.implementation

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdk = Version.compileSdk
    buildToolsVersion = Version.buildTool

    defaultConfig {
        applicationId = "com.baraka.example"
        minSdk = Config.minSdkVersion.toInt()
        targetSdk = Config.targetVersion.toInt()
        versionCode = Config.versionCode
        versionName = Config.versionName
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "1.8"
        //useIR = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }

    buildFeatures {
        compose = true
    }
}

androidProject()

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.2")

    implementation ( "androidx.compose.runtime:runtime-livedata:${Version.compose}")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0")
    implementation ( "androidx.activity:activity-compose:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.0")

    implementation ("com.google.android.material:material:1.6.1")

    implementation("androidx.compose.ui:ui:${Version.compose}")
    // Tooling support (Previews, etc.)
    implementation( "androidx.compose.ui:ui-tooling:${Version.compose}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation( "androidx.compose.foundation:foundation:${Version.compose}")
    // Material Design
    implementation( "androidx.compose.material:material:${Version.compose}")

    implementation ("androidx.compose.material:material-icons-extended:${Version.compose}")

    implementation("androidx.navigation:navigation-compose:2.5.0")

    implementation (project(":repository"))

    implementation (AppDependencies.paged)

    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
}