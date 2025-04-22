package com.example.feature_wallet

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core_navigation.Navigable
import com.example.core_navigation.NavigableGraphEntryPoint
import com.example.core_navigation.OnNavigateTo
import kotlinx.serialization.Serializable

sealed class WalletGraphRoute : Navigable {
    @Serializable
    data object Screen1 : WalletGraphRoute()
    @Serializable
    data object Screen2 : WalletGraphRoute()
}

fun NavGraphBuilder.addWalletGraph(
    navController: NavController,
    onNavigateToFlow: OnNavigateTo
) =
    navigation<NavigableGraphEntryPoint.WalletFlowEntryPoint>(
        startDestination = WalletGraphRoute.Screen1,
    ) {
        composable<WalletGraphRoute.Screen1> {
            FeatureWalletScreen1(
                onNext = { navController.navigate(WalletGraphRoute.Screen2) },
            )
        }
        composable<WalletGraphRoute.Screen2> {
            FeatureWalletScreen2(
                onBack = { navController.popBackStack() },
            )
        }
    }
