package com.kyawlinnthant.feed.presentation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.kyawlinnthant.feed.presentation.profile.ProfileScreen
import com.kyawlinnthant.navigation.Graph
import com.kyawlinnthant.navigation.Screen

fun NavGraphBuilder.feedGraph(
    controller: NavHostController
) {
    navigation(
        startDestination = Screen.Profile.name,
        route = Graph.Feature.route
    ) {
        composable(route = Screen.Profile.name) {
            ProfileScreen()
        }
    }
}