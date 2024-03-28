package com.example.myshoppinglist.ui.shopping.list

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ShoppingListRoute: String = "shopping-list"

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.shoppingListNavigation(
    shoppingListViewModel: ShoppingListViewModel,
    onNavigateToShoppingItemCreation: () -> Unit
) {
    composable(ShoppingListRoute) {
        val shoppingListState: ShoppingListState by shoppingListViewModel.state.collectAsStateWithLifecycle()

        ShoppingListPage(shoppingListState, onNavigateToShoppingItemCreation, shoppingListViewModel::update)
    }
}