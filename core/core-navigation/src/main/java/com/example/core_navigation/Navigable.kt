package com.example.core_navigation

import androidx.navigation.NavOptionsBuilder

interface Navigable

data object PreviousScreen : Navigable

typealias OnNavigateTo = (Navigable, NavOptionsBuilder.() -> Unit) -> Unit
