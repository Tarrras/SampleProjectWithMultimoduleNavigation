package com.example.feature_auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureAuthScreen2(
    modifier: Modifier = Modifier,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseEmptyScreen(
        text = "FeatureAuthScreen2",
        onNext = onNext,
        onBack = onBack
    )
}