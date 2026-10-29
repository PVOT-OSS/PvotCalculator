/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val versionMajor = rootProject.extra["versionMajor"] as Int
val versionMinor = rootProject.extra["versionMinor"] as Int
val versionPatch = rootProject.extra["versionPatch"] as Int
val computedVersionCode = rootProject.extra["computedVersionCode"] as Int
val computedVersionName = rootProject.extra["computedVersionName"] as String

android {
    compileSdk = 35
    namespace = "org.prauga.calculator"

    defaultConfig {
        applicationId = "org.prauga.calculator"
        minSdk = 31
        targetSdk = 35
        versionCode = computedVersionCode
        versionName = computedVersionName

        buildConfigField("int", "VERSION_MAJOR", "$versionMajor")
        buildConfigField("int", "VERSION_MINOR", "$versionMinor")
        buildConfigField("int", "VERSION_PATCH", "$versionPatch")
    }

    buildTypes {
        getByName("release") {
            // Enables code shrinking, obfuscation, and optimization.
            isMinifyEnabled = true

            // Enables resource shrinking.
            isShrinkResources = true

            // Includes the default ProGuard rules files.
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            )
        }
        getByName("debug") {
            // Append .dev to package name so we won't conflict with AOSP build.
            applicationIdSuffix = ".dev"
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.androidx.gridlayout)
    implementation(libs.androidx.webkit)
    implementation(libs.material)
    implementation(libs.crcalc)
}
