package com.nishan.pacepal

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.nishan.auth.presentation.intro.IntroScreenRoot
import com.nishan.auth.presentation.register.RegisterScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination = "auth")
    {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "intro"
    ){
        composable(
            route = "intro"
        ){
            IntroScreenRoot(
                onSignInClick = {
                    navController.navigate("register")
                },
                onSignUpClick = {
                    navController.navigate("login")
                }
            )
        }

        composable(
            route = "register"
        ) {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate("login") {
                        popUpTo("register") {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate("login")
                }
            )
        }
    }
}