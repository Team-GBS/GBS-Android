plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.gbs.gbs_android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.gbs.gbs_android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependency.Androidx.CORE_KTX)
    implementation(Dependency.Androidx.LIFECYCLE)
    implementation(Dependency.Androidx.COMPOSE)
    implementation(Dependency.Androidx.COMPOSE_UI)
    implementation(Dependency.Androidx.COMPOSE_PREVIEW)
    implementation(Dependency.Androidx.MATERIAL3)
    testImplementation(Dependency.UnitTest.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Dependency.Androidx.COMPOSE_JUNIT)
    debugImplementation(Dependency.Androidx.COMPOSE_TOOLING)
    debugImplementation(Dependency.Androidx.COMPOSE_MANIFEST)
}