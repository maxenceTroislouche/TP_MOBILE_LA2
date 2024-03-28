package com.example.myshoppinglist.ui.shopping.createitem

import com.example.myshoppinglist.data.dto.ShoppingItem


fun ShoppingCreateItemState.toDto(id: Int): ShoppingItem {
    return ShoppingItem(id, label, count.toFloat(), unit)
}