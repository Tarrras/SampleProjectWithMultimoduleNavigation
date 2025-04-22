package com.example.feature_wallet

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureWalletScreen1(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    BaseEmptyScreen(text = "FeatureWalletScreen1", onNext = onNext)
}