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
package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Purple200
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DetailContent(
    id: String,
    imgUrl: String,
    name: String,
    age: String,
    gender: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple200)
    ) {
        Column {
            GlideImage(
                data = imgUrl,
                contentDescription = null
            )
            Text(
                id,
                textAlign = TextAlign.Center
            )
            Text(
                name,
                textAlign = TextAlign.Center
            )
            Text(
                gender,
                textAlign = TextAlign.Center
            )
            Text(
                age,
                textAlign = TextAlign.Center
            )
            Text(
                description,
                textAlign = TextAlign.Center
            )
            TextButton(
                onClick = {},
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                Text(stringResource(R.string.adapt), textAlign = TextAlign.Center)
            }
        }
    }
}
