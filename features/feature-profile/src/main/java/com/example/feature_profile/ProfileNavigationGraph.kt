package com.example.feature_profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core_navigation.Navigable
import com.example.core_navigation.NavigableGraphEntryPoint
import com.example.core_navigation.NavigableMainGraphEntryPoint
import com.example.core_navigation.OnNavigateTo
import kotlinx.serialization.Serializable

sealed class ProfileGraphRoute : Navigable {
    @Serializable
    data object Screen1 : ProfileGraphRoute()

    @Serializable
    data object Screen2 : ProfileGraphRoute()
}

fun NavGraphBuilder.addProfileGraph(
    navController: NavController,
    onNavigateToFlow: OnNavigateTo
) = navigation<NavigableGraphEntryPoint.ProfileFlowEntryPoint>(
    startDestination = ProfileGraphRoute.Screen1,
) {
    composable<ProfileGraphRoute.Screen1> {
        FeatureProfileScreen1(
            onNext = { navController.navigate(ProfileGraphRoute.Screen2) },
        )
    }
    composable<ProfileGraphRoute.Screen2> {
        FeatureProfileScreen2(
            onNext = { onNavigateToFlow(NavigableMainGraphEntryPoint.AuthFlowMainEntryPoint) {} },
            onBack = { navController.popBackStack() },
        )
    }
}
