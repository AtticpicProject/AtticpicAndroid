plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = AppConfig.completeSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

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
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Dependencies.Design.appCompat)
    implementation(Dependencies.Design.material)
    implementation(Dependencies.Design.constraintLayout)

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.coroutines)

    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitConverterMoshi)
    implementation(Dependencies.Retrofit.okhttpLoggingInterceptor)

    implementation(Dependencies.Moshi.moshi)
    kapt(Dependencies.Moshi.moshiCodegen)

    implementation(Dependencies.NavigationComponent.navigationRuntime)
    implementation(Dependencies.NavigationComponent.navigationFragment)
    implementation(Dependencies.NavigationComponent.navigationUi)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}

kapt {
    correctErrorTypes = true
}
