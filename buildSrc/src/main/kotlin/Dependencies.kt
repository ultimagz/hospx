object Apps {
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildTools = "29.0.2"
}

object Versions {
    const val gradle = "3.6.0"
    const val kotlin = "1.3.61"

    /* AndroidX */
    const val androidXCore = "1.2.0"
    const val androidXAppcompat = "1.1.0"
    const val androidXActivity = "1.1.0"
    const val androidXFragment = "1.2.2"
    const val androidXConstraintLayout = "1.1.3"
    const val androidXRecyclerView = "1.0.0"
    const val androidXMultiDex = "2.0.1"
    const val androidXPreferencesKtx = "1.1.0"
    const val androidXWorkManagerKtx = "2.3.1"
    const val androidXExifInterface = "1.1.0"
    const val androidXCollectionKtx = "1.1.0"
    const val androidXAsyncLayoutInflater = "1.0.0"
    const val androidXBiometric = "1.0.1"
    const val androidXCardView = "1.0.0"
    const val androidXCoordinatorLayout = "1.1.0"
    const val androidXVectorDrawable = "1.1.0"
    const val androidXTransition = "1.3.0"

    /* AndroidX Architecture Components */
    const val androidXArch = "2.1.0"
    const val androidXLifeCycle = "2.2.0"
    const val androidXArchNavigation = "2.1.0"

    /* Google Play */
    const val googlePlayCore = "1.6.5"

    /* Network */
    const val retrofit = "2.7.1"
    const val ktxSerializationConverter = "0.4.0"
    const val loggingInterceptor = "4.4.0"

    /* DI */
    const val koin = "2.0.1"

    /* Glide */
    const val glide = "4.11.0"

    /* Utils */
    const val arrowKt = "0.10.4"
    const val timber = "4.7.1"
    const val materialComponents = "1.0.0"
    const val threeTenAbp = "1.2.2"

        /* Test */
    const val junit = "4.12"
    const val mockito = "3.2.4"
    const val mockitoKt = "2.2.0"
    const val ktxCoroutinesTest = "1.3.2"

    /* Android Test*/
    const val androidXJunit = "1.1.1"
    const val androidXEspresso = "3.2.0"
    const val androidXFragmentTesting = "1.2.2"
}

object AndroidXLibs {
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidXCore}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.androidXAppcompat}"
    const val activity = "androidx.activity:activity:${Versions.androidXActivity}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.androidXActivity}"
    const val fragment = "'androidx.fragment:fragment:${Versions.androidXFragment}"
    const val fragmentKtx = "'androidx.fragment:fragment-ktx:${Versions.androidXFragment}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidXConstraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.androidXRecyclerView}"
    const val multiDex = "androidx.multidex:multidex:${Versions.androidXMultiDex}"
    const val preferencesKtx = "androidx.preference:preference-ktx:${Versions.androidXPreferencesKtx}"
    const val workManagerktx = "androidx.work:work-runtime-ktx:${Versions.androidXWorkManagerKtx}"
    const val exifInterface = "androidx.exifinterface:exifinterface:${Versions.androidXExifInterface}"
    const val collectionKtx = "androidx.collection:collection-ktx:${Versions.androidXCollectionKtx}"
    const val asyncLayoutInflater = "androidx.asynclayoutinflater:asynclayoutinflater:${Versions.androidXAsyncLayoutInflater}"
    const val biometric = "androidx.biometric:biometric:${Versions.androidXBiometric}"
    const val cardView = "androidx.cardview:cardview:${Versions.androidXCardView}"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.androidXCoordinatorLayout}"
    const val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.androidXVectorDrawable}"
    const val vectorDrawableAnimated = "androidx.vectordrawable:vectordrawable-animated:${Versions.androidXVectorDrawable}"
    const val transition = "androidx.transition:transition:${Versions.androidXTransition}"
}

object AndroidXArch {
    const val coreRuntime = "androidx.arch.core:core-runtime:${Versions.androidXArch}"

    const val lifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidXLifeCycle}"
    const val lifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidXLifeCycle}"
    const val lifeCycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.androidXLifeCycle}"
    const val lifeCycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.androidXLifeCycle}"

    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.androidXArchNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.androidXArchNavigation}"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    /* Arrow-Kt */
    const val arrowFx = "io.arrow-kt:arrow-fx:${Versions.arrowKt}"
    const val arrowOptics = "io.arrow-kt:arrow-optics:${Versions.arrowKt}"
    const val arrowSyntax = "io.arrow-kt:arrow-syntax:${Versions.arrowKt}"
    const val arrowMeta = "io.arrow-kt:arrow-meta:${Versions.arrowKt}"

    /* KOIN */
    const val koin = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val koinExt = "org.koin:koin-android-ext:${Versions.koin}"

    /* Retrofit */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val ktxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.ktxSerializationConverter}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    /* Glide */
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    /* Utils */
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:${Versions.threeTenAbp}"
}

object GooglePlay {
    const val core = "com.google.android.play:core:${Versions.googlePlayCore}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
    const val mockitoKt = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKt}"
    const val ktxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.ktxCoroutinesTest}"
    const val arrowTest = "io.arrow-kt:arrow-test:${Versions.arrowKt}"
}

object AndroidTestLibs {
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.androidXFragmentTesting}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.androidXArch}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidXEspresso}"
    const val junit = "androidx.test.ext:junit:${Versions.androidXJunit}"
}