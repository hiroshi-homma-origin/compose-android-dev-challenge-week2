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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.primaryText
import com.example.androiddevchallenge.ui.theme.primaryVariant

@Composable
fun TimenrCounter(
    value: Int,
    increment: () -> Unit,
    decrement: () -> Unit
) {
    val formattedValue = remember(value) { String.format("%02d", value) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryVariant
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = { increment.invoke() }
        ) {
            Icon(
                modifier = Modifier.size(45.dp),
                imageVector = Icons.Filled.ExpandLess,
                contentDescription = "Up",
                tint = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = formattedValue,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.End,
                color = primaryText
            )
        }
        Button(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryVariant
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = { decrement.invoke() }
        ) {
            Icon(
                modifier = Modifier.size(45.dp),
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = "Up",
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun TimenrCounterPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .size(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryVariant
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = { },
        ) {
            Icon(
                modifier = Modifier.size(45.dp),
                imageVector = Icons.Filled.ExpandLess,
                contentDescription = "Up",
                tint = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "20",
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.End,
                color = primaryText
            )
        }
        Button(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryVariant
            ),
            contentPadding = PaddingValues(0.dp),
            onClick = { },
        ) {
            Icon(
                modifier = Modifier.size(45.dp),
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = "Up",
                tint = Color.White
            )
        }
    }
}
