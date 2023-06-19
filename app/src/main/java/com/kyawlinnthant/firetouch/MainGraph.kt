package com.kyawlinnthant.firetouch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kyawlinnthant.auth.presentation.graph.authGraph
import com.kyawlinnthant.feed.presentation.graph.feedGraph
import com.kyawlinnthant.navigation.Graph
import com.kyawlinnthant.navigation.NavigationInstructor

@Composable
fun MainGraph() {
    val vm: MainViewModel = hiltViewModel()
    val isLoggedIn = vm.isLoggedIn.collectAsState()
    val instructor = vm.instructor
    val navController = rememberNavController()

    NavigationInstructor(
        instructor = instructor,
        controller = navController
    )

    isLoggedIn.value?.let {
        val startDestination = if (it) Graph.Feature.route else Graph.Auth.route
        NavHost(
            navController = navController,
            startDestination = startDestination,
            route = Graph.Root.route
        ) {
            authGraph(navController)
            feedGraph(navController)
        }
    }
}
