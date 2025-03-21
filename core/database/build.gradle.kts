plugins {
    alias(libs.plugins.pacepal.android.library)
    alias(libs.plugins.pacepal.android.room)
}

android {
    namespace = "com.nishan.core.database"

}

dependencies {

    implementation(libs.org.mongodb.bson)
    implementation(projects.core.domain)
}