plugins {

	alias(libs.plugins.pacepal.android.feature.ui)

}


android {
	namespace = "com.nishan.auth.presentation"

}

dependencies {


	implementation(project(":auth:domain"))
	implementation(projects.core.domain)
}