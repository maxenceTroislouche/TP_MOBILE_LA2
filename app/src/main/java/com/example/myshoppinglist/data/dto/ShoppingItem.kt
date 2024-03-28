package com.example.myshoppinglist.data.dto

import java.util.UUID

data class ShoppingItem(
    val id: UUID,
    val label: String,
    val count: Float,
    val unit: String,
)