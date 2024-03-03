plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.footballleague"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.footballleague"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.football-data.org/\"")
            buildConfigField("String", "API_KEY", "\"4ad40c57895c4189989f2b9751a93d44\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.football-data.org/\"")
            buildConfigField("String", "API_KEY", "\"4ad40c57895c4189989f2b9751a93d44\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    ksp(libs.hilt.android.compiler)
    ksp(libs.moshi.codegen)
    ksp(libs.room.android.compiler)
    implementation(libs.timber)
    implementation(libs.sdp.scalable.size)
    implementation(libs.ssp.scalable.size)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.hilt.android)
    implementation(libs.moshi)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.room.android)
    implementation(libs.room.android.runtime)
    implementation(libs.coil.image)
}