package com.kyawlinnthant.navigation

sealed class Screen(val name: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object ForgotPassword : Screen("password")
    object Profile : Screen("profile")
    object Feed : Screen("feed")
}