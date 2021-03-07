/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.presentation.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.presentation.custom.CustomCircularProgressIndicator

@ExperimentalAnimationApi
@Composable
fun TimerScreen(progress: Float, label: String) {
    Box(
        modifier = Modifier.aspectRatio(ratio = 1f),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(
            modifier = Modifier
                .width(220.dp)
                .height(220.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.LightGray,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.width / 2,
                style = Stroke(20.dp.toPx())
            )
        }
        CustomCircularProgressIndicator(
            modifier = Modifier.width(240.dp)
                .height(240.dp),
            progress = progress,
            strokeWidth = 20.dp
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = label,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun TimerComponentPreview() {
    Box(
        modifier = Modifier.aspectRatio(ratio = 1f)
            .background(Color.White), // Test Imp
        contentAlignment = Alignment.Center,
    ) {
        Canvas(
            modifier = Modifier
                .width(220.dp)
                .height(220.dp)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.LightGray,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.width / 2,
                style = Stroke(19.dp.toPx())
            )
        }
        CustomCircularProgressIndicator(
            modifier = Modifier.width(240.dp)
                .height(240.dp),
            progress = -0.5f,
            strokeWidth = 20.dp
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "00:12",
                style = MaterialTheme.typography.h4
            )
        }
    }
}
