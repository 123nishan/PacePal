plugins {
    alias(libs.plugins.pacepal.android.library)
}

android {
    namespace = "com.nishan.run.data"


}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)
    implementation(projects.core.database)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
    implementation(libs.androidx.work)
    implementation(libs.koin.android.workmanager)
    implementation(libs.kotlinx.serialization.json)
}