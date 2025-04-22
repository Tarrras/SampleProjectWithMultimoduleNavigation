package com.example.feature_auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core_navigation.Navigable
import com.example.core_navigation.NavigableMainGraphEntryPoint
import kotlinx.serialization.Serializable

sealed class AuthGraphRoute: Navigable {
    @Serializable data object Screen1: AuthGraphRoute()
    @Serializable data object Screen2: AuthGraphRoute()
}

fun NavGraphBuilder.addAuthGraph(navController: NavController) =
    navigation<NavigableMainGraphEntryPoint.AuthFlowMainEntryPoint>(
        startDestination = AuthGraphRoute.Screen1,
    ) {
        composable<AuthGraphRoute.Screen1> {
            FeatureAuthScreen1(
                onNext = { navController.navigate(AuthGraphRoute.Screen2) },
            )
        }
        composable<AuthGraphRoute.Screen2> {
            FeatureAuthScreen2(
                onNext = { navController.navigate(NavigableMainGraphEntryPoint.MainFlowMainEntryPoint) },
                onBack = { navController.popBackStack() },
            )
        }
    }
