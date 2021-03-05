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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.presentation.common.SubmitButton
import com.example.androiddevchallenge.ui.presentation.common.TimenrCounter
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@ExperimentalAnimationApi
@Composable
fun TimeSetScreen(
    isStarted: Boolean,
    seconds: String,
    onSecondsChange: (String) -> Unit,
    onStartCountdown: () -> Unit,
    onStopCountdown: () -> Unit
) {
    val viewModel = viewModel<CountdownViewModel>()
    val uiState by viewModel.timerState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = !isStarted) {
            Column(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    modifier = Modifier.width(260.dp)
                        .padding(top = 30.dp)
                        .wrapContentHeight(),
                    value = seconds,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions { onStartCountdown() },
                    onValueChange = onSecondsChange,
                    label = { Text("Time Set(Seconds)?") }
                )
                Row(
                    modifier = Modifier.wrapContentSize()
                        .padding(top = 20.dp, bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TimenrCounter(
                        uiState.hour,
                        { viewModel.incrementHours() },
                        { viewModel.decrementHours() }
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.padding(bottom = 9.dp),
                        style = MaterialTheme.typography.h3
                    )
                    TimenrCounter(
                        uiState.minutes,
                        { viewModel.incrementMinutes() },
                        { viewModel.decrementMinutes() }
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.padding(bottom = 9.dp),
                        style = MaterialTheme.typography.h3
                    )
                    TimenrCounter(
                        uiState.seconds,
                        { viewModel.incrementSeconds() },
                        { viewModel.decrementSeconds() }
                    )
                }
            }
        }
        SubmitButton(isStarted, seconds, onStartCountdown, onStopCountdown)
    }
}

@Preview
@ExperimentalAnimationApi
@Composable
fun TimeSetScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White), // Test Imp
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = true) {
            Column(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    modifier = Modifier.width(120.dp)
                        .padding(top = 30.dp)
                        .wrapContentHeight(),
                    value = "20",
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions { },
                    onValueChange = { },
                    label = { Text("Time Set?") }
                )
                Row(
                    modifier = Modifier.wrapContentSize()
                        .padding(top = 20.dp, bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TimenrCounter(
                        1,
                        { },
                        { }
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.padding(bottom = 9.dp),
                        style = MaterialTheme.typography.h3
                    )
                    TimenrCounter(
                        2,
                        { },
                        { }
                    )
                    Text(
                        text = ":",
                        modifier = Modifier.padding(bottom = 9.dp),
                        style = MaterialTheme.typography.h3
                    )
                    TimenrCounter(
                        3,
                        { },
                        { }
                    )
                }
            }
        }
        SubmitButton(false, "10", { }, { })
    }
}
