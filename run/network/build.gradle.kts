plugins {
    alias(libs.plugins.pacepal.android.library)
    alias(libs.plugins.pacepal.jvm.ktor)
}

android {
    namespace = "com.nishan.run.network"

}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.appcompat)
//    implementation(libs.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}