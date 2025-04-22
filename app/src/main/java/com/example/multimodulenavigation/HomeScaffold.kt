package com.example.multimodulenavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core_navigation.Navigable
import com.example.core_navigation.OnNavigateTo
import com.example.core_navigation.isStartDestination
import com.example.feature_profile.ProfileFlowEntryPoint
import com.example.feature_profile.addProfileGraph
import com.example.feature_wallet.WalletFlowEntryPoint
import com.example.feature_wallet.addWalletGraph

@Composable
internal fun HomeScaffold(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onNavigate: OnNavigateTo,
) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentTabScreen =
        items.find { currentDestination?.parent?.hasRoute(it::class) == true }
    val isRootScreen = currentDestination?.isStartDestination() == true

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (isRootScreen) {
                Row(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    items.forEach { item ->
                        val isSelected = currentTabScreen == item
                        Icon(
                            imageVector = item.icon,
                            tint = if (isSelected) {
                                Color.Blue
                            } else {
                                Color.Gray
                            },
                            contentDescription = null,
                            modifier = Modifier.clickable(
                                onClick = {
                                    navController.navigate(item) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        )
                    }
                }
            }
        },
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = WalletFlowEntryPoint,
            modifier = Modifier.systemBarsPadding(),
        ) {
            addWalletGraph(onNavigateToFlow = onNavigate, navController = navController)
            addProfileGraph(onNavigateToFlow = onNavigate, navController = navController)
        }
    }
}

private val items = listOf(
    WalletFlowEntryPoint,
    ProfileFlowEntryPoint,
)

private val Navigable.icon
    get() =
        when (this) {
            WalletFlowEntryPoint -> Icons.Default.Home
            //ProfileFlowEntryPoint
            else -> Icons.Default.Menu
        }
