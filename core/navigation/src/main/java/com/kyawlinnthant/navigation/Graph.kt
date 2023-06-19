package com.kyawlinnthant.navigation

sealed class Graph(val route: String) {
    object Root : Graph("root")
    object Auth : Graph("authentication")
    object Feature : Graph("feature")
}
