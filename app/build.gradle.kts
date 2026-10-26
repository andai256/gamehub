plugins {
    id("com.android.application")
}

android {
    namespace = "io.github.andai256.gamehub"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.andai256.gamehub"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Keep the APK free of Google's dependency-metadata blob (F-Droid recommendation)
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
}
