package com.example.myshoppinglist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myshoppinglist.ui.shared.theme.MyShoppingListTheme
import com.example.myshoppinglist.ui.shopping.createitem.ShoppingCreateItemViewModel
import com.example.myshoppinglist.ui.shopping.createitem.navigateToShoppingItemCreation
import com.example.myshoppinglist.ui.shopping.createitem.shoppingCreateItemNavigation
import com.example.myshoppinglist.ui.shopping.list.ShoppingListViewModel
import com.example.myshoppinglist.ui.shopping.list.shoppingListNavigation

class MainActivity : ComponentActivity() {
    @SuppressLint("ComposableDestinationInComposeScope")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val shoppingListViewModel by viewModels<ShoppingListViewModel>()
            val shoppingCreateItemViewModel by viewModels<ShoppingCreateItemViewModel>()
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "shopping-list",
            ) {
                shoppingListNavigation(
                    shoppingListViewModel = shoppingListViewModel,
                    onNavigateToShoppingItemCreation = navController::navigateToShoppingItemCreation
                )
                shoppingCreateItemNavigation(
                    shoppingCreateItemViewModel,
                    onNavigateToShoppingList = { navController.navigateUp() })
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyShoppingListTheme {
        Column {
//            ShoppingItemCard(ShoppingItem(1, "Poireau", 0.5f,"kg"))
//            ShoppingItemCard(ShoppingItem(2, "Pomme de terre", 2f,"kg"))
        }
    }
}