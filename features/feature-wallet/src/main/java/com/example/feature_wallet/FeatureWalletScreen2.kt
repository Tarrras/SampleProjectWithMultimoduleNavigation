package com.example.feature_wallet

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core_design.BaseEmptyScreen

@Composable
fun FeatureWalletScreen2(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    BaseEmptyScreen(
        text = "FeatureWalletScreen2",
        onNext = null,
        onBack = onBack
    )
}