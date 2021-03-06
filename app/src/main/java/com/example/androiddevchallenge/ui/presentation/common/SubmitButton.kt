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

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.primaryVariant
import com.example.androiddevchallenge.ui.theme.secondaryText
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@Composable
fun SubmitButton(
    isStarted: Boolean,
    seconds: String
) {
    val viewModel = viewModel<CountdownViewModel>()
    Button(
        modifier = Modifier.padding(top = 20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = primaryVariant
        ),
        enabled = isStarted || !isStarted && seconds.isNotBlank(),
        onClick = {
            if (isStarted) viewModel.stopCountdown()
            else viewModel.startCountdown()
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 10.dp
        )
    ) {
        Text(text = if (isStarted) "STOP" else "START")
    }
}

@Preview
@Composable
fun SubmitButtonPreview() {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = secondaryText
        ),
        enabled = true,
        onClick = { },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 10.dp
        )
    ) {
        Text(text = "START")
    }
}
