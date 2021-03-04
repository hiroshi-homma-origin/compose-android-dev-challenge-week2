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

import android.app.Application
import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CountdownViewModel @ViewModelInject constructor(
    application: Application
) : AndroidViewModel(application) {

    private var timer: CountDownTimer? = null

    private val _isStarted = MutableStateFlow(false)
    val isStarted: StateFlow<Boolean> = _isStarted

    private val _setupSeconds = MutableStateFlow(0L)
    val setupSeconds: StateFlow<Long> = _setupSeconds

    private val _countdownLabel = MutableStateFlow("")
    val countdownLabel: StateFlow<String> = _countdownLabel

    private val _countdownProgress = MutableStateFlow(1f)
    val countdownProgress: StateFlow<Float> = _countdownProgress

    fun setSeconds(seconds: Long) {
        _setupSeconds.value = seconds
    }

    fun startCountdown() {
        _isStarted.value = true

        timer = object : CountDownTimer(_setupSeconds.value * 1000, 16) {
            override fun onTick(millisUntilFinished: Long) {
                _countdownProgress.value =
                    millisUntilFinished.toFloat() / 1000 / _setupSeconds.value
                _countdownLabel.value = formatTime(millisUntilFinished)
            }

            override fun onFinish() {
                stopCountdown()
            }
        }.start()
    }

    fun stopCountdown() {
        timer?.apply {
            cancel()
            timer = null
        }

        _countdownProgress.value = 0f
        _countdownLabel.value = ""
        _isStarted.value = false
    }

    private fun formatTime(millis: Long) = DateUtils.formatElapsedTime((millis + 1000).div(1000))
}
