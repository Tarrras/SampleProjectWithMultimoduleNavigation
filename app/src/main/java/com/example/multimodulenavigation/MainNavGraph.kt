package com.example.multimodulenavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.core_navigation.Navigable
import com.example.core_navigation.NavigableMainGraphEntryPoint
import com.example.core_navigation.PreviousScreen
import com.example.feature_auth.addAuthGraph
import com.example.feature_profile.addProfileGraph
import com.example.feature_wallet.addWalletGraph

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: NavigableMainGraphEntryPoint = NavigableMainGraphEntryPoint.AuthFlowMainEntryPoint,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        //Auth flow
        addAuthGraph(navController)

        //Main flow
        composable<NavigableMainGraphEntryPoint.MainFlowMainEntryPoint> {
            HomeScaffold(onNavigate = { destination, optionsBuilder ->
                navController.navigateTo(destination, navOptions(optionsBuilder))
            })
        }
    }
}

private fun NavHostController.navigateTo(
    destination: Navigable,
    navOptions: NavOptions?,
) {
    when (destination) {
        is PreviousScreen -> {
            val isBackStackEmpty = previousBackStackEntry == null
            if (!isBackStackEmpty) popBackStack()
        }

        else -> navigate(destination, navOptions)
    }
}
