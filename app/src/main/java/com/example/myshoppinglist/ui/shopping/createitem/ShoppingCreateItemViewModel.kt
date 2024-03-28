package com.example.myshoppinglist.ui.shopping.createitem

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myshoppinglist.data.service.addArticle

class ShoppingCreateItemViewModel : ViewModel() {
    private var _shoppingItemCreationState = mutableStateOf(ShoppingCreateItemState("", "", ""))

    val shoppingItemCreationState: State<ShoppingCreateItemState>
        get() = _shoppingItemCreationState

    fun changeItemLabel(label: String) {
        val currentState = _shoppingItemCreationState.value
        _shoppingItemCreationState.value = currentState.copy(label = label)
    }

    fun changeItemCount(count: String) {
        val currentState = _shoppingItemCreationState.value
        _shoppingItemCreationState.value = currentState.copy(count = count)
    }

    fun changeItemUnit(unit: String) {
        val currentState = _shoppingItemCreationState.value
        _shoppingItemCreationState.value = currentState.copy(unit = unit)
    }

    fun createItem() {
        addArticle(shoppingItemCreationState.value)
    }
}
