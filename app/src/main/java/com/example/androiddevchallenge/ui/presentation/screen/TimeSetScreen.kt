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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.presentation.common.SubmitButton
import com.example.androiddevchallenge.ui.presentation.common.WheelUpController
import com.example.androiddevchallenge.ui.presentation.custom.CustomTextField

@ExperimentalAnimationApi
@Composable
fun TimeSetScreen(
    isStarted: Boolean,
    seconds: String
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AnimatedVisibility(visible = !isStarted) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CustomTextField(seconds)
                    TimerCounterScreen()
                    WheelUpController()
                }
            }
            SubmitButton(isStarted, seconds)
        }
    }
}

@Preview
@ExperimentalAnimationApi
@Composable
fun TimeSetScreenPreview() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
//            AnimatedVisibility(visible = true) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    CustomTextFieldPreview()
//                    TimerCounterScreenPreview()
//                    WheelUpControllerPreview()
//                }
//            }
            SubmitButton(false, "10")
        }
    }
}
