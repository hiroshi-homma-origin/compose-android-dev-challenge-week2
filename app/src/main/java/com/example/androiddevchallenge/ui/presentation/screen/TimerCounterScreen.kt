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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.presentation.common.TimenrCounter
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@Composable
fun TimerCounterScreen() {
    val viewModel = viewModel<CountdownViewModel>()
    val timerState by viewModel.timerState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            TimenrCounter(
                timerState.hour,
                { viewModel.incrementHours() },
                { viewModel.decrementHours() }
            )
            Text(
                text = ":",
                modifier = Modifier.padding(top = 36.dp),
                style = MaterialTheme.typography.h3
            )
            TimenrCounter(
                timerState.minutes,
                { viewModel.incrementMinutes() },
                { viewModel.decrementMinutes() }
            )
            Text(
                text = ":",
                modifier = Modifier.padding(top = 36.dp),
                style = MaterialTheme.typography.h3
            )
            TimenrCounter(
                timerState.seconds,
                { viewModel.incrementSeconds() },
                { viewModel.decrementSeconds() }
            )
        }
    }
}

@Preview
@Composable
fun TimerCounterScreenPreview() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            TimenrCounter(
                1,
                { },
                { }
            )
            Text(
                text = ":",
                modifier = Modifier.padding(top = 36.dp),
                style = MaterialTheme.typography.h3
            )
            TimenrCounter(
                2,
                { },
                { }
            )
            Text(
                text = ":",
                modifier = Modifier.padding(top = 36.dp),
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
