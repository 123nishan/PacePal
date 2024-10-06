plugins {
   alias(libs.plugins.pacepal.android.library)
}

android {
    namespace = "com.nishan.core.data"
}

dependencies {

    implementation(libs.timber)
    implementation(projects.core.domain)
    implementation(projects.core.database)
}