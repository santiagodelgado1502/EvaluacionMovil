/*
 * Copyright (C) 2022 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.ui.item

import com.example.inventory.data.Vuelo

/**
 * Represents Ui State for an Item.
 */
data class ItemUiState(
    val id: Int = 0,
    val ruta: String = "",
    val precio: String = "",
    val escalas: String = "",
    val pasajeros: String = "",
    val actionEnabled: Boolean = false
)

/**
 * Extension function to convert [ItemUiState] to [Item]. If the value of [ItemUiState.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun ItemUiState.toItem(): Vuelo = Vuelo(
    id = id,
    ruta = ruta,
    precio = precio.toDoubleOrNull() ?: 0.0,
    escalas = escalas.toDoubleOrNull() ?: 0.0,
    pasajeros = pasajeros.toDoubleOrNull() ?: 0.0

)

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Vuelo.toItemUiState(actionEnabled: Boolean = false): ItemUiState = ItemUiState(
    id = id,
    ruta = ruta,
    precio = precio.toString(),
    escalas = escalas.toString(),
    pasajeros = pasajeros.toString(),
    actionEnabled = actionEnabled
)

fun ItemUiState.isValid() : Boolean {
    return ruta.isNotBlank() && precio.isNotBlank() && escalas.isNotBlank() && pasajeros.isNotBlank()
 }
