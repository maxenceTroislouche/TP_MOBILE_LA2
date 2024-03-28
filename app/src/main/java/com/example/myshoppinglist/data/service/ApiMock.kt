package com.example.myshoppinglist.data.service

import com.example.myshoppinglist.data.dto.ShoppingItem
import com.example.myshoppinglist.ui.shopping.createitem.ShoppingCreateItemState
import com.example.myshoppinglist.ui.shopping.createitem.toDto

private val mockedShoppingListDataBase = mutableListOf(
    ShoppingItem(
        id = 0,
        label = "Pomme de terre",
        count = 12f,
        unit = "Kg",
    ),
    ShoppingItem(
        id = 1,
        label = "Fraise",
        count = 500f,
        unit = "g",
    ),
    ShoppingItem(
        id = 2,
        label = "Lait",
        count = 1f,
        unit = "L",
    ),
    ShoppingItem(
        id = 3,
        label = "Eau",
        count = 1.5f,
        unit = "L",
    ),
)

fun retrieveShoppingList(): List<ShoppingItem> = mockedShoppingListDataBase

fun addArticle(shoppingItem: ShoppingCreateItemState) {
    mockedShoppingListDataBase.add(shoppingItem.toDto(getNextUnusedId()))
}

private fun getNextUnusedId(): Int = mockedShoppingListDataBase.maxOf {
    it.id
}.inc()