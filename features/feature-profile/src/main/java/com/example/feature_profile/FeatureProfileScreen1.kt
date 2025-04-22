package com.example.feature_profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureProfileScreen1(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    BaseEmptyScreen(text = "FeatureProfileScreen1", onNext = onNext)
}