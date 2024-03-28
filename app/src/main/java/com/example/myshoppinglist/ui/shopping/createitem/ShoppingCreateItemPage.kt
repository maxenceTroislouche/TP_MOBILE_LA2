package com.example.myshoppinglist.ui.shopping.createitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myshoppinglist.ui.shared.theme.MyShoppingListTheme

@Composable
fun ShoppingCreateItemPage(
    shoppingCreateItemState: ShoppingCreateItemState,
    onNavigateToShoppingList: () -> Unit,
    changeLabel: (label: String) -> Unit,
    changeCount: (count: String) -> Unit,
    changeUnit: (unit: String) -> Unit,
    createItem: () -> Unit,
) {
    val headerText = "Create your item"

    // val text = "$label: $count$unit"
    // val duration = Toast.LENGTH_SHORT
    // val toast = Toast.makeText(LocalContext.current, text, duration)

    Scaffold(bottomBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { createItem(); onNavigateToShoppingList() },
            ) {
                Text("Add to my list")
            }
        }

    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Row {
                Text(
                    text = headerText,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        // Start - top - end - botton
                        .padding(0.dp, 32.dp, 0.dp, 0.dp)
                        .fillMaxWidth()
                )
            }
            TextField(
                value = shoppingCreateItemState.label,
                onValueChange = {
                    changeLabel(it)
                },
                label = { Text("Label") },
                placeholder = { Text("Pomme de terre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 32.dp, 32.dp, 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                ),
            )
            TextField(
                value = shoppingCreateItemState.count,
                onValueChange = {
                    changeCount(it)
                },
                label = { Text("Count") },
                placeholder = { Text("2") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 16.dp, 32.dp, 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number,
                ),
            )
            TextField(
                value = shoppingCreateItemState.unit,
                onValueChange = {
                    changeUnit(it)
                },
                label = { Text("Unit") },
                placeholder = { Text("kg") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 16.dp, 32.dp, 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
            )

        }
    }
}

@Composable
@Preview(showBackground = false)
fun ShoppingListPagePreview() {
    MyShoppingListTheme {
        ShoppingCreateItemPage(ShoppingCreateItemState("", "", ""), {}, {}, {}, {}, {})
    }
}