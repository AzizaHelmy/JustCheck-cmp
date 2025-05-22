@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
  //  alias(libs.plugins.composeCompiler)
    kotlin("plugin.serialization") version "1.9.0"
   // alias(libs.plugins.sqldelight)
 //   alias(libs.plugins.kotlinCocoapods)
}

kotlin {
    targetHierarchy.default()

    androidTarget {}

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(libs.kotlin.coroutines)

                // Koin
                implementation("io.insert-koin:koin-core:3.5.3")
                implementation(libs.koin.compose)
                api(libs.koin.core)
             //   implementation("ru.pocketbyte.kotlin-uuid:library:0.5.0")


                // Ktor
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.json.serialization)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(compose.preview)
                implementation(libs.androidx.activity.compose)
                implementation("io.ktor:ktor-client-android:2.3.7")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.7")
            }
        }
    }
}

android {
    namespace = "org.aziza.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.aziza.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}