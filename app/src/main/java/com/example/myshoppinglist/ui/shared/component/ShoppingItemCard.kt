package com.example.myshoppinglist.ui.shared.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.ui.shopping.list.ShoppingItemState
import com.example.myshoppinglist.ui.shared.theme.MyShoppingListTheme
import com.example.myshoppinglist.ui.shared.theme.Typography
import com.example.myshoppinglist.utils.ShoppingItemCountFormatter

@Composable
fun ShoppingItemCard(item: ShoppingItemState) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text(
                style = Typography.headlineMedium,
                text = item.label,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    style = Typography.bodyLarge,
                    text = ShoppingItemCountFormatter.format(item.count),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    style = Typography.bodyLarge,
                    text = item.unit,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = false)
fun ShoppingItemCardPreview() {
    MyShoppingListTheme {
        ShoppingItemCard(ShoppingItemState(1, "Poireau", 0.5f,"kg"))
    }
}