plugins {
   alias(libs.plugins.pacepal.android.library)
    alias(libs.plugins.pacepal.jvm.ktor)
}

android {
    namespace = "com.nishan.core.data"
}

dependencies {

    implementation(libs.timber)
    implementation(projects.core.domain)
    implementation(projects.core.database)
}