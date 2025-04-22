package com.example.feature_profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureProfileScreen2(
    modifier: Modifier = Modifier,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    BaseEmptyScreen(
        text = "FeatureProfileScreen2",
        onNext = onNext,
        onBack = onBack
    )
}