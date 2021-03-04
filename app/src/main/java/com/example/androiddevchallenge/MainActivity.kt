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
package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.presentation.CountDownScreen
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalAnimationApi
@Composable
fun MyApp(countdownViewModel: CountdownViewModel = viewModel()) {

    val context = LocalContext.current
    countdownViewModel.apply {
        val isStarted by isStarted.collectAsState(false)
        val seconds by setupSeconds.collectAsState(initial = 0L)
        val progress by countdownProgress.collectAsState(1.0f)
        val label by countdownLabel.collectAsState(initial = "")

        CountDownScreen(
            isStarted = isStarted,
            seconds = if (seconds == 0L) "" else seconds.toString(),
            progress = progress,
            label = label,
            onSecondsChange = { countdownViewModel.setSeconds(it.toLongOrNull() ?: 0L) },
            onStartCountdown = {
                Toast.makeText(context, "Started!", Toast.LENGTH_SHORT).show()
                countdownViewModel.startCountdown()
            },
            onStopCountdown = {
                Toast.makeText(context, "Stopped!", Toast.LENGTH_SHORT).show()
                countdownViewModel.stopCountdown()
            }
        )
    }
}

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
