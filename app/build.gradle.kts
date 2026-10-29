/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = 35
    namespace = "com.android.calculator2"

    defaultConfig {
        applicationId = "com.android.calculator2"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
