plugins {
	alias(libs.plugins.pacepal.android.library)
	alias(libs.plugins.pacepal.jvm.ktor)
}

android {
	namespace = "com.nishan.auth.data"

}

dependencies {
	implementation(libs.bundles.koin)
implementation(projects.auth.domain)
implementation(projects.core.domain)
implementation(projects.core.data)
//	implementation(libs.appcompat)
//	implementation(libs.material)
//	testImplementation(libs.junit)
//	androidTestImplementation(libs.androidx.junit)
//	androidTestImplementation(libs.androidx.espresso.core)
}