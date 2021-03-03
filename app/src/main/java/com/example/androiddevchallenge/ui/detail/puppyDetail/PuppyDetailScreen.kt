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
package com.example.androiddevchallenge.ui.detail.puppyDetail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.ui.common.DetailContent
import com.example.androiddevchallenge.ui.common.DetailTopBar
import com.kotlin.project.dogAndCat.R

@Composable
fun PuppyDetailScreen(id: Int, navController: NavController) {
    val viewModelFactory = PuppyDetailViewModel.Factory(id)
    val viewModel = viewModel(PuppyDetailViewModel::class.java, factory = viewModelFactory)
    val puppy = viewModel.puppy.collectAsState()

    Scaffold(
        topBar = {
            DetailTopBar(
                title = stringResource(R.string.puppyDetail),
                navController = navController
            )
        }
    ) {
        DetailContent(
            id = puppy.value.id.toString(),
            imgUrl = puppy.value.imgUrl,
            name = puppy.value.name,
            age = puppy.value.age,
            gender = puppy.value.gender,
            description = puppy.value.description
        )
    }
}
