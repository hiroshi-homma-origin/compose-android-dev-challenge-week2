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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.Purple500
import com.kotlin.project.dogAndCat.R

@Composable
fun ListSelectTab(navController: NavController) {
    val puttiesName = stringResource(R.string.puppies)
    val kittensName = stringResource(R.string.kittens)
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(46.dp)
            .padding(4.dp, 2.dp, 4.dp, 2.dp)
            .background(Purple500, shape = RoundedCornerShape(8.dp)),
        horizontalArrangement = Arrangement.Center
    ) {
        TextButton(
            onClick = {
                navController.navigateUp()
            },
            modifier = Modifier
                .padding(4.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            Text(puttiesName, textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = {
                navController.navigate(kittensName)
            },
            modifier = Modifier
                .padding(4.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            Text(kittensName, textAlign = TextAlign.Center)
        }
    }
}
