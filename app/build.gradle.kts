apply(rootProject.file("gradle/generated-kotlin-sources.gradle"))

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildTools)

    defaultConfig {
        applicationId = "gz.tar.ultimagz.hospx"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        resConfigs("en", "th")
    }

    viewBinding {
        isEnabled = true
    }

    dataBinding {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
        isQuiet = true
    }

    packagingOptions {
        exclude("META-INF/notice.txt")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")
    sourceSets["test"].java.srcDir("src/test/kotlin")
    sourceSets["androidTest"].java.srcDir("src/androidTest/kotlin")

    sourceSets["test"].resources.srcDirs("src/resources")
    sourceSets["androidTest"].resources.srcDirs("src/resources")
}

dependencies {
    project(":domain")
    project(":data")

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin)

    implementation(GooglePlay.core)

    implementation(AndroidXLibs.coreKtx)
    implementation(AndroidXLibs.appcompat)
    implementation(AndroidXLibs.constraintLayout)
    implementation(AndroidXLibs.recyclerView)
    implementation(AndroidXLibs.multiDex)
    implementation(AndroidXLibs.preferencesKtx)
    implementation(AndroidXLibs.cardView)
    implementation(AndroidXLibs.vectorDrawable)
    implementation(AndroidXLibs.vectorDrawableAnimated)
    implementation(AndroidXLibs.transition)
    implementation(AndroidXLibs.collectionKtx)
    implementation(AndroidXLibs.workManagerktx)
    implementation(AndroidXLibs.camera)
    implementation(AndroidXLibs.cameraLifeCycle)
    implementation(AndroidXLibs.cameraView)
    implementation(AndroidXLibs.cameraExt)

    implementation(AndroidXArch.coreRuntime)
    implementation(AndroidXArch.lifeCycleViewModel)
    implementation(AndroidXArch.lifeCycleLiveData)
    implementation(AndroidXArch.lifeCycleSavedState)
    implementation(AndroidXArch.navigationFragmentKtx)
    implementation(AndroidXArch.navigationUiKtx)
    kapt(AndroidXArch.lifeCycleCompiler)

    implementation(Libs.retrofit)
    implementation(Libs.ktxSerializationConverter)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.arrowFx)
    implementation(Libs.arrowOptics)
    implementation(Libs.arrowSyntax)
    kapt(Libs.arrowMeta)

    implementation(Libs.koin)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinExt)
    implementation(Libs.koinViewModel)

    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    implementation(Libs.timber)
    implementation(Libs.threeTenAbp)
    implementation(Libs.imageCropper)
    implementation(Libs.materialComponents)
    implementation(Libs.lottie)

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.mockitoAndroid)
    testImplementation(TestLibs.mockitoKt)
    testImplementation(TestLibs.ktxCoroutinesTest)
    testImplementation(TestLibs.arrowTest)

    androidTestImplementation(AndroidTestLibs.junit)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.coreTesting)
    androidTestImplementation(AndroidTestLibs.fragmentTesting)
}

kapt {
    correctErrorTypes = true
}