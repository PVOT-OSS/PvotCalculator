/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

ext {
    val versionMajor = 1
    val versionMinor = 0
    val versionPatch = 0

    set("versionMajor", versionMajor)
    set("versionMinor", versionMinor)
    set("versionPatch", versionPatch)
    set("computedVersionCode", versionMajor * 10000 + versionMinor * 100 + versionPatch)
    set("computedVersionName", "$versionMajor.$versionMinor.$versionPatch")
}
