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

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.detail.kittenDetail.KittenDetailScreen
import com.example.androiddevchallenge.ui.detail.puppyDetail.PuppyDetailScreen
import com.example.androiddevchallenge.ui.list.kittens.KittensScreen
import com.example.androiddevchallenge.ui.list.puppies.PuppiesScreen
import com.example.androiddevchallenge.ui.theme.DogAndCatTheme
import timber.log.Timber

@SuppressLint("RestrictedApi")
@ExperimentalFoundationApi
@Composable
fun AppContents() {
    val navController = rememberNavController()
    val puttiesName = stringResource(R.string.puppies)
    val kittensName = stringResource(R.string.kittens)
    val puppyDetailName = stringResource(R.string.puppyDetailRoute)
    val kittenDetailName = stringResource(R.string.kittenDetailRoute)

    DogAndCatTheme {
        NavHost(navController, startDestination = puttiesName) {
            composable(puttiesName) {
                Timber.d("current_s1:${navController.currentDestination?.displayName}")
                PuppiesScreen(navController)
            }
            composable(kittensName) {
                KittensScreen(navController)
            }
            composable(
                puppyDetailName,
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments!!.getInt("id")
                PuppyDetailScreen(id, navController)
            }
            composable(
                kittenDetailName,
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments!!.getInt("id")
                KittenDetailScreen(id, navController)
            }
        }
    }
}
