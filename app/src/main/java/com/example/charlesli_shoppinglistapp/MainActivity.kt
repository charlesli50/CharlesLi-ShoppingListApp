package com.example.charlesli_shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.charlesli_shoppinglistapp.ui.theme.CharlesLiShoppingListAppTheme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharlesLiShoppingListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Shopping(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Shopping(modifier: Modifier = Modifier) {

    var items by remember { mutableStateOf(listOf<String>()) }
    var itemQuantity by remember { mutableStateOf(listOf<Int>()) }
    var itemPurchased by remember { mutableStateOf(listOf<Boolean>()) }
    items = listOf("kit kat", "twizzlers", "chocolate")
    itemQuantity = listOf(1, 2, 3)
    itemPurchased = listOf(false, false, false)

    var itemName by remember { mutableStateOf("") }
    var itemQ by remember { mutableStateOf("0") }


    Text(
        text = "Welcome to my shopping list",
        modifier = Modifier.padding(20.dp),
        textAlign = TextAlign.Center
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(top = 40.dp).padding(20.dp)
    ) {
        items(items.size) { index ->
            val item = items[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("${item}", style = MaterialTheme.typography.titleMedium)
                    Text("Quantity: ${itemQuantity[index]}", textAlign = TextAlign.Start)
                }

                Checkbox(
                    checked = itemPurchased[index],
                    onCheckedChange = { }
                )

            }
        }
    }



    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp).padding(top = 250.dp)){

        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Item Name") },
//                modifier = Modifier.weight(1f)
        )
        Button(
        onClick = {
            if (itemName.isNotBlank()) {
                items = items + itemName
                itemName = ""
                itemQuantity = itemQuantity + itemQ.toInt()
                itemQ = "0"
                itemPurchased = itemPurchased + false
            }
        }
    ) {
        Text("Add(This will not work yet)")
    } }

//    Text("${items[items.size-1]}", modifier = Modifier)



}

@Preview(showBackground = true)
@Composable
fun ShoppingPreview() {
    CharlesLiShoppingListAppTheme {
        Shopping()
    }
}