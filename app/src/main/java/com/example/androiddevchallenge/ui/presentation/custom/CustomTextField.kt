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
package com.example.androiddevchallenge.ui.presentation.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@Composable
fun CustomTextField(
    seconds: String
) {
    val viewModel = viewModel<CountdownViewModel>()
    OutlinedTextField(
        modifier = Modifier.wrapContentSize(),
        value = seconds,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions { viewModel.startCountdown() },
        onValueChange = { viewModel.setSeconds(it.toLongOrNull() ?: 0L) },
        label = { Text("Time Set(Seconds)?") }
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    OutlinedTextField(
        modifier = Modifier.wrapContentSize()
            .background(Color.White), // Preview Only
        value = "20",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions { },
        onValueChange = { },
        label = { Text("Time Set(Seconds)?") }
    )
}
