plugins {
	alias(libs.plugins.pacepal.android.library.compose)
}

android {
	namespace = "com.nishan.core.presentation.designsystem"

}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	api(libs.androidx.compose.material3)
}