package com.kyawlinnthant.auth.presentation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.kyawlinnthant.auth.presentation.forgotpassword.ForgotPasswordScreen
import com.kyawlinnthant.auth.presentation.login.LoginScreen
import com.kyawlinnthant.auth.presentation.register.RegisterScreen
import com.kyawlinnthant.navigation.Graph
import com.kyawlinnthant.navigation.Screen

fun NavGraphBuilder.authGraph(
    controller: NavHostController
) {
    navigation(
        startDestination = Screen.Login.name,
        route = Graph.Auth.route
    ) {
        composable(route = Screen.Login.name) {
            LoginScreen()
        }
        composable(route = Screen.Register.name) {
            RegisterScreen()
        }
        composable(route = Screen.ForgotPassword.name) {
            ForgotPasswordScreen()
        }
    }
}