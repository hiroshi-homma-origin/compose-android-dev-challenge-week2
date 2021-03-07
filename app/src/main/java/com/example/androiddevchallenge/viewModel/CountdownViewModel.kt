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
package com.example.androiddevchallenge.viewModel

import android.app.Application
import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.example.androiddevchallenge.data.model.TimerState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountdownViewModel @ViewModelInject constructor(
    application: Application
) : AndroidViewModel(application) {

    private var timer: CountDownTimer? = null

    private val _isStarted = MutableStateFlow(false)
    val isStarted: StateFlow<Boolean> = _isStarted

    private val _setupSeconds = MutableStateFlow(0L)
    val setupSeconds: StateFlow<Long> = _setupSeconds

    private val _labelData = MutableStateFlow("")
    val labelData: StateFlow<String> = _labelData

    private val _progressValue = MutableStateFlow(1f)
    val progressValue: StateFlow<Float> = _progressValue

    private val _timerState = MutableStateFlow(TimerState())
    val timerState = _timerState.asStateFlow()

    fun setSeconds(seconds: Long) {
        _setupSeconds.value = seconds

        _timerState.value = TimerState(
            hour = seconds.toInt() / 3600,
            minutes = (seconds.toInt() / 60) % 60,
            seconds = seconds.toInt() % 60,
            progress = seconds.toFloat() / 1000 / _setupSeconds.value
        )
    }

    fun secondsFromState() {
        _setupSeconds.value = (
                _timerState.value.hour * 3600 +
                        _timerState.value.minutes * 60 +
                        _timerState.value.seconds
                ).toLong()
    }

    fun startCountdown() {
        _isStarted.value = true

        timer = object : CountDownTimer(_setupSeconds.value * 1000, 16) {
            override fun onTick(millisUntilFinished: Long) {
                _progressValue.value =
                    millisUntilFinished.toFloat() / 1000 / _setupSeconds.value
                _labelData.value = formatTime(millisUntilFinished)
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

        _progressValue.value = 0f
        _labelData.value = ""
        _isStarted.value = false
    }

    private fun formatTime(millis: Long) = DateUtils.formatElapsedTime((millis + 1000).div(1000))

    // --- counter control (Here can be simpler...)---//

    fun incrementHours() {
        _timerState.value = _timerState.value.run {
            when {
                _timerState.value.hour >= 24 ->
                    copy(
                        hour = 0,
                        minutes = 0,
                        seconds = 0
                    )
                else -> {
                    if (_timerState.value.hour == 23) {
                        copy(
                            hour = 0,
                            minutes = 0,
                            seconds = 0
                        )
                    } else {
                        copy(hour = hour + 1)
                    }
                }
            }
        }
        secondsFromState()
    }

    fun decrementHours() {
        _timerState.value = _timerState.value.run {
            when {
                _timerState.value.hour <= 0 -> copy(hour = 24)
                else -> copy(hour = hour - 1)
            }
        }
        secondsFromState()
    }

    fun incrementMinutes() {
        _timerState.value = _timerState.value.run {
            val setHour = if (_timerState.value.hour < 24) {
                _timerState.value.hour + 1
            } else {
                0
            }
            when {
                _timerState.value.minutes >= 59 -> {
                    copy(
                        hour = setHour,
                        minutes = 0,
                        seconds = 0
                    )
                }
                else -> {
                    if (_timerState.value.hour == 24) {
                        copy(
                            hour = 0,
                            minutes = 0,
                            seconds = 0
                        )
                    } else {
                        copy(minutes = minutes + 1)
                    }
                }
            }
        }
        secondsFromState()
    }

    fun decrementMinutes() {
        _timerState.value = _timerState.value.run {
            when {
                _timerState.value.minutes <= 0 -> {
                    if (_timerState.value.hour == 24) {
                        copy(hour = 23, minutes = 59)
                    } else {
                        copy(minutes = 59)
                    }
                }
                else -> copy(minutes = minutes - 1)
            }
        }
        secondsFromState()
    }

    fun incrementSeconds() {
        _timerState.value = _timerState.value.run {
            val setMinutes = if (_timerState.value.minutes < 59) {
                _timerState.value.minutes + 1
            } else {
                0
            }
            val setHour = if (_timerState.value.minutes > 58) {
                if (_timerState.value.hour == 23) {
                    0
                } else {
                    _timerState.value.hour + 1
                }
            } else {
                _timerState.value.hour
            }
            when {
                _timerState.value.seconds >= 59 -> {
                    copy(
                        hour = setHour,
                        minutes = setMinutes,
                        seconds = 0
                    )
                }
                else -> {
                    if (_timerState.value.hour == 24) {
                        copy(
                            hour = 0,
                            minutes = 0,
                            seconds = 0
                        )
                    } else {
                        copy(seconds = seconds + 1)
                    }
                }
            }
        }
        secondsFromState()
    }

    fun decrementSeconds() {
        _timerState.value = _timerState.value.run {
            when {
                _timerState.value.seconds <= 0 -> {
                    if (_timerState.value.hour == 24) {
                        copy(hour = 23, seconds = 59)
                    } else {
                        copy(seconds = 59)
                    }
                }
                else -> copy(seconds = seconds - 1)
            }
        }
        secondsFromState()
    }
}
