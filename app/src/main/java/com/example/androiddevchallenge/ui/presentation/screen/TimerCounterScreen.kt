package com.example.androiddevchallenge.ui.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.presentation.common.TimenrCounter
import com.example.androiddevchallenge.viewModel.CountdownViewModel

@Composable
fun TimerCounterScreen() {
    val viewModel = viewModel<CountdownViewModel>()
    val timerState by viewModel.timerState.collectAsState()
    Row(
        modifier = Modifier.wrapContentSize()
            .padding(top = 20.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TimenrCounter(
            timerState.hour,
            { viewModel.incrementHours() },
            { viewModel.decrementHours() }
        )
        Text(
            text = ":",
            modifier = Modifier.padding(bottom = 9.dp),
            style = MaterialTheme.typography.h3
        )
        TimenrCounter(
            timerState.minutes,
            { viewModel.incrementMinutes() },
            { viewModel.decrementMinutes() }
        )
        Text(
            text = ":",
            modifier = Modifier.padding(bottom = 9.dp),
            style = MaterialTheme.typography.h3
        )
        TimenrCounter(
            timerState.seconds,
            { viewModel.incrementSeconds() },
            { viewModel.decrementSeconds() }
        )
    }
}

@Preview
@Composable
fun TimerCounterScreenPreview() {
    Row(
        modifier = Modifier.wrapContentSize()
            .padding(top = 20.dp, bottom = 20.dp)
            .background(Color.White), // Preview Only
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