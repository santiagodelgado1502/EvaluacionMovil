/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

class OfflineVuelosRepository(private val itemDao: VueloDao) : VuelosRepository {
    override fun getAllItemsStream(): Flow<List<Vuelo>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Vuelo?> = itemDao.getItem(id)

    override suspend fun insertItem(vuelo: Vuelo) = itemDao.insert(vuelo)

    override suspend fun deleteItem(vuelo: Vuelo) = itemDao.delete(vuelo)

    override suspend fun updateItem(vuelo: Vuelo) = itemDao.update(vuelo)
}