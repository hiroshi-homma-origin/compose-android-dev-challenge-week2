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
package com.example.androiddevchallenge.ui.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubmitButton(
    isStarted: Boolean,
    seconds: String,
    onStartCountdown: () -> Unit,
    onStopCountdown: () -> Unit
) {
    Button(
        modifier = Modifier.padding(vertical = 12.dp),
        enabled = isStarted || !isStarted && seconds.isNotBlank(),
        onClick = { if (isStarted) onStopCountdown() else onStartCountdown() }
    ) {
        Text(text = if (isStarted) "STOP" else "START")
    }
}
