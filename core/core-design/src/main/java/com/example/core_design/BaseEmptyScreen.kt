package com.example.core_design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseEmptyScreen(
    text: String = "Empty Screen",
    onBack: (() -> Unit)? = null,
    onNext: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        onBack?.let {
            Spacer(Modifier.weight(1f))
            Box {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onBack()
                        },
                    tint = Color.Black
                )
            }
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = text,
        )
        Spacer(Modifier.weight(1f))
        onNext?.let {
            Text(
                text = "Next", fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onNext()
                    }
            )
            Spacer(Modifier.weight(1f))

        }
    }
}