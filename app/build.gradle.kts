plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize")
}

android {
    namespace = "com.ProiectSI"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.ProiectSI"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.gson)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v261)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.core.animation)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("de.greenrobot:eventbus:2.4.0")

    implementation("com.github.bumptech.glide:glide:4.16.0")




    debugImplementation(libs.androidx.fragment.testing)

    androidTestImplementation (libs.androidx.runner)
    androidTestImplementation (libs.androidx.rules)
    // Optional -- UI testing with Espresso
    androidTestImplementation (libs.androidx.espresso.core)
    // Optional -- UI testing with UI Automator
    androidTestImplementation (libs.androidx.uiautomator)
    // Optional -- UI testing with Compose
    androidTestImplementation (libs.ui.test.junit4)



// Required -- JUnit 4 framework
    testImplementation (libs.junit)
    // Optional -- Robolectric environment
    testImplementation (libs.androidx.core)
    // Optional -- Mockito framework
    // Optional -- mockito-kotlin
    testImplementation (libs.x.github.com.mockito.mockito.kotlin)

// Core library
    androidTestImplementation (libs.androidx.core)

    // AndroidJUnitRunner and JUnit Rules
    androidTestImplementation (libs.androidx.runner)
    androidTestImplementation (libs.androidx.rules)

    // Assertions
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.truth)

    // Espresso dependencies
    androidTestImplementation (libs.androidx.espresso.core)
    androidTestImplementation (libs.androidx.espresso.contrib)
    androidTestImplementation (libs.androidx.espresso.intents)
    androidTestImplementation (libs.androidx.espresso.accessibility)
    androidTestImplementation (libs.androidx.espresso.web)
    androidTestImplementation (libs.androidx.idling.concurrent)

    // The following Espresso dependency can be either "implementation",
    // or "androidTestImplementation", depending on whether you want the
    // dependency to appear on your APK’"s compile classpath or the test APK
    // classpath.
    androidTestImplementation (libs.androidx.espresso.idling.resource)

// https://mvnrepository.com/artifact/androidx.test/core
    implementation("androidx.test:core:1.6.1")
}