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
package com.example.androiddevchallenge.ui.list.puppies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.common.ListCard
import com.example.androiddevchallenge.ui.theme.Purple200

@ExperimentalFoundationApi
@Composable
fun PuppiesGridView(
    puppies: State<List<Puppy>>,
    navController: NavController
) {
    val spanCount = 3
    LazyVerticalGrid(
        cells = GridCells.Fixed(spanCount),
        modifier = Modifier.background(Purple200)
    ) {
        items(puppies.value.size) { index ->
            Column {
                if (index < spanCount) Spacer(modifier = Modifier.height(45.dp))
                ListCard(
                    route = "${stringResource(R.string.puppyDetail)}/${puppies.value[index].id}",
                    imgUrl = puppies.value[index].imgUrl,
                    name = puppies.value[index].name,
                    navController = navController
                )
            }
        }
    }
}
