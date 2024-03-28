package com.example.myshoppinglist.ui.shopping.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.R
import com.example.myshoppinglist.ui.shared.component.ShoppingItemCard
import com.example.myshoppinglist.ui.shared.theme.MyShoppingListTheme

@Composable
fun ShoppingListPage(
    shoppingListState: ShoppingListState,
    onNavigateToShoppingItemCreation: () -> Unit,
    updateShoppingListState: () -> Unit,
) {
    // val text = "Add a new element to your list !"
    // val duration = Toast.LENGTH_SHORT
    // val toast = Toast.makeText(LocalContext.current, text, duration)
    updateShoppingListState()

    val shoppingList = shoppingListState.shoppingList

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick =
            onNavigateToShoppingItemCreation
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = stringResource(R.string.contentDescription)
            )
        }

    }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(shoppingList) { item ->
                Row {
                    ShoppingItemCard(item = item)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = false)
fun ShoppingListPagePreview() {
    MyShoppingListTheme {
        ShoppingListPage(ShoppingListState(), {}, {})
    }
}