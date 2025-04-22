package com.example.core_navigation

import kotlinx.serialization.Serializable

// App main flows
sealed class NavigableMainGraphEntryPoint: Navigable {
    @Serializable data object MainFlowMainEntryPoint : NavigableMainGraphEntryPoint()
    @Serializable data object AuthFlowMainEntryPoint : NavigableMainGraphEntryPoint()
}

// App sub flows
sealed class NavigableGraphEntryPoint: Navigable {
    @Serializable data object WalletFlowEntryPoint : NavigableGraphEntryPoint()
    @Serializable data object ProfileFlowEntryPoint : NavigableGraphEntryPoint()
}