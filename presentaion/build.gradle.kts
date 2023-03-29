import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Dependency.GradlePlugin.ANDROID_APPLICATION)
    id(Dependency.GradlePlugin.KOTLIN_ANDROID)
    id(Dependency.GradlePlugin.HILT)
    kotlin("kapt")
}

android {
    namespace = "com.gbs.gbs_android"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.gbs.gbs_android"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "GAUTH_KEY", getApiKey("GAUTH_KEY"))
        buildConfigField("String", "GAUTH_KEY_SECRET", getApiKey("GAUTH_KEY_SECRET"))
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
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}

dependencies {
    implementation(project(":data"))
    implementation(project(":di"))

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
    implementation(Dependency.Androidx.SPLASH)
    implementation(Dependency.GAuth.GAUTH)
    implementation(Dependency.Androidx.NAVIGATION)
    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)
    implementation(Dependency.Androidx.HILT_NAVIGATION_COMPOSE)
}