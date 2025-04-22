package com.example.feature_auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureAuthScreen1(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    BaseEmptyScreen(text = "FeatureAuthScreen1", onNext = onNext)
}