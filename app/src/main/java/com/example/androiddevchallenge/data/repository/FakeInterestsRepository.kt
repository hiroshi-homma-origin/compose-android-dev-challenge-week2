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
package com.example.androiddevchallenge.data.repository

import com.example.androiddevchallenge.data.mock.TestData.kittens
import com.example.androiddevchallenge.data.mock.TestData.puppies
import com.example.androiddevchallenge.data.model.Kitten
import com.example.androiddevchallenge.data.model.Puppy

interface InterestsRepository {
    fun getPuppies(): List<Puppy>
    fun getKittens(): List<Kitten>
    fun getPuppy(id: Int): Puppy
    fun getKitten(id: Int): Kitten
}

class FakePuppiesAndKittensRepository : InterestsRepository {
    override fun getPuppies() = puppies
    override fun getKittens() = kittens
    override fun getPuppy(id: Int) = puppies.first { it.id == id }
    override fun getKitten(id: Int) = kittens.first { it.id == id }
}
