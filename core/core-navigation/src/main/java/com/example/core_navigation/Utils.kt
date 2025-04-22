package com.example.core_navigation

import androidx.navigation.NavDestination
import androidx.navigation.compose.ComposeNavigator

fun NavDestination.isStartDestination() = this.parent?.startDestinationRoute == this.route