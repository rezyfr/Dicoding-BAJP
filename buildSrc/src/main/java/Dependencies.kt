object DefaultConfig {
    const val appId = "com.rezyfr.submission1"

    const val minSdk = 21
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.3"

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlinVersion = "1.4.20"
    const val coreKtxVersion = "1.3.2"
    const val appCompatVersion = "1.2.0"
    const val materialVersion = "1.3.0"
    const val constraintLayoutVersion = "2.0.4"

    const val activityKtxVersion = "1.1.0"
    const val fragmentKtxVersion = "1.2.5"
    const val lifecycleVersion = "1.1.1"
    const val navVersion = "2.3.4"

    const val glideVersion = "4.10.0"
    const val glideLegacyVersion = "1.0.0"
    const val glideKaptVersion = "4.10.0"

    const val mockkVersion = "1.10.0"
    const val junitVersion = "4.13"
    const val extJunitVersion = "1.1.2"
    const val espressoVersion = "3.3.0"
}

object Dependencies {
    // Base
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val lifeCycle = "android.arch.lifecycle:extensions:${Versions.lifecycleVersion}"

    // Other
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideLegacy = "androidx.legacy:legacy-support-v4:${Versions.glideLegacyVersion}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glideKaptVersion}"

    // Test
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val espressoContrib =
        "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
}