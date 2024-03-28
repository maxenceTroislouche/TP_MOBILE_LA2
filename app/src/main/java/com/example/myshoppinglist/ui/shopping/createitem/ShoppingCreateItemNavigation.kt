package com.example.myshoppinglist.ui.shopping.createitem

import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val shoppingCreateItemRoute = "shopping-create-item"


fun NavGraphBuilder.shoppingCreateItemNavigation(
    shoppingCreateItemViewModel: ShoppingCreateItemViewModel,
    onNavigateToShoppingList: () -> Unit
) {
    composable(shoppingCreateItemRoute) {
        val shoppingCreateItemState: ShoppingCreateItemState by shoppingCreateItemViewModel.shoppingItemCreationState

        ShoppingCreateItemPage(
            shoppingCreateItemState,
            onNavigateToShoppingList,
            shoppingCreateItemViewModel::changeItemLabel,
            shoppingCreateItemViewModel::changeItemCount,
            shoppingCreateItemViewModel::changeItemUnit,
            shoppingCreateItemViewModel::createItem
        )
    }
}

fun NavController.navigateToShoppingItemCreation() {
    navigate(shoppingCreateItemRoute)
}