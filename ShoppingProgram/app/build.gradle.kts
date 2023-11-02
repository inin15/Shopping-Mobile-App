plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.shoppingprogram"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shoppingprogram"
        minSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment:2.7.4")
    implementation("androidx.navigation:navigation-ui:2.7.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Declare Meow Bottom Navigation
    //implementation("com.etebarian:meow-bottom-navigation-java:1.2.0")
    //Declare Recycler View
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    //Declare Card View
    implementation("androidx.cardview:cardview:1.0.0")
    //Fix React Native Android builds "Duplicate class kotlin.collections."
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61")
}