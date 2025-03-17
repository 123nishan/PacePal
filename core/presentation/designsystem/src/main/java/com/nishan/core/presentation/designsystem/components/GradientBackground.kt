package com.nishan.core.presentation.designsystem.components

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nishan.core.presentation.designsystem.PacePalTheme

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    hasToolbar: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
/*
* provides information about the current screen width, height and orientation.
* */
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    val screenWidthPx = with(density){
        configuration.screenWidthDp.dp.roundToPx()
    }
    val smallDimension = minOf(
        configuration.screenWidthDp.dp,
        configuration.screenHeightDp.dp
    )

    val smallDimensionPx = with(density){
        smallDimension.roundToPx()
    }

    val primaryColor = MaterialTheme.colorScheme.primary
    val isAtLeastAndroid12 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .then(
                    if(isAtLeastAndroid12){
                        modifier.blur(
                            smallDimension / 3f
                        )
                    }else modifier
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            if(isAtLeastAndroid12) primaryColor else primaryColor.copy(alpha = 0.3f),
                            MaterialTheme.colorScheme.background
                        ),
                        center = Offset(
                            x = screenWidthPx / 2f,
                            y = -200f
                        ),
                        radius = smallDimensionPx / 2f
                    )
                )
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if(hasToolbar){
                        Modifier
                    }else {
                        Modifier.systemBarsPadding()
                    }
                )
        ){
            content()
        }
    }
}

@Preview
@Composable
private fun GradientBackgroundPreview() {
    PacePalTheme {
        GradientBackground (
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}