package com.example.myshoppinglist.ui.shopping.list

import androidx.lifecycle.ViewModel
import com.example.myshoppinglist.data.dto.ShoppingItem
import com.example.myshoppinglist.data.service.retrieveShoppingList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel() : ViewModel() {
    private val _state: MutableStateFlow<ShoppingListState> = MutableStateFlow(ShoppingListState())
    val state: StateFlow<ShoppingListState>
        get() = _state.asStateFlow()

    init {
        update()
    }

    fun update() {
        val shoppingList: List<ShoppingItem> = retrieveShoppingList()
        val mutableList: MutableList<ShoppingItemState> = listOf<ShoppingItemState>().toMutableList()

        for (shoppingItem: ShoppingItem in shoppingList) {
            mutableList.add(
                ShoppingItemState(
                    id = shoppingItem.id,
                    label = shoppingItem.label,
                    count = shoppingItem.count,
                    unit = shoppingItem.unit
                )
            )
        }

        _state.update {shoppingListState ->
            shoppingListState.copy(shoppingList = mutableList)
        }
    }
}