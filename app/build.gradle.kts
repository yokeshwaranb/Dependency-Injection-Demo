plugins {
    alias(libs.plugins.androidApplication)
//    id 'kotlin-kapt'
    id("com.google.dagger.hilt.android") version "2.51.1"
}

android {
    namespace = "com.personalproject.dependencyinjectiondemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.personalproject.dependencyinjectiondemo"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Dependencies for Hilt
    // Ref: https://developer.android.com/training/dependency-injection/hilt-android#kts
    // I hope annotationProcessor is fine
    implementation("com.google.dagger:hilt-android:2.51.1")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.51.1")
}

// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//}