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
package com.example.androiddevchallenge.ui.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@Composable
fun WheelUpController() {
    var offset by remember { mutableStateOf(0f) }
    var rotation by remember { mutableStateOf(0f) }
    val state = rememberTransformableState { _, _, rotationChange ->
        rotation += rotationChange
    }
    val viewModel = viewModel<CountdownViewModel>()
    viewModel.setSeconds(offset.toLong())
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { scrollableState ->
                    offset += scrollableState / 3f
                    if (offset < 0) offset = 0F
                    if (offset > 86400) offset = 86400F
                    scrollableState
                }
            ),
        contentAlignment = Alignment.TopCenter,
    ) {
        Canvas(
            modifier = Modifier
                .width(140.dp)
                .height(140.dp)
                .padding(8.dp)
                .graphicsLayer(rotationZ = offset)
                .transformable(state = state)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.LightGray,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                style = Stroke(4.dp.toPx())
            )
            drawLine(
                color = Color.LightGray,
                start = Offset((canvasWidth / 2), 15f),
                end = Offset((canvasWidth / 2), (canvasHeight / 2)),
                strokeWidth = 16f,
                cap = StrokeCap.Round,
                alpha = 1.0f
            )
        }
    }
}

@Preview
@Composable
fun WheelUpControllerPreview() {
    var offset by remember { mutableStateOf(0f) }
    var rotation by remember { mutableStateOf(0f) }
    val state = rememberTransformableState { _, _, rotationChange ->
        rotation += rotationChange
    }
    Box(
        modifier = Modifier
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { scrollableState ->
                    offset += scrollableState / 3f
                    if (offset < 0) offset = 0F
                    if (offset > 86399) offset = 86399F
                    scrollableState
                }
            ),
        contentAlignment = Alignment.TopCenter,
    ) {
        Canvas(
            modifier = Modifier
                .width(140.dp)
                .height(140.dp)
                .padding(8.dp)
                .graphicsLayer(rotationZ = offset)
                .transformable(state = state)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.LightGray,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                style = Stroke(4.dp.toPx())
            )
            drawLine(
                color = Color.LightGray,
                start = Offset((canvasWidth / 2), 15f),
                end = Offset((canvasWidth / 2), (canvasHeight / 2)),
                strokeWidth = 16f,
                cap = StrokeCap.Round,
                alpha = 1.0f
            )
        }
    }
}
