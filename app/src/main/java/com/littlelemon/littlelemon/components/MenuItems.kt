package com.littlelemon.littlelemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.littlelemon.littlelemon.components.menuitems.ProductCard
import com.littlelemon.littlelemon.components.menuitems.model.ProductItem
import com.littlelemon.littlelemon.ui.theme.LLCloud
import com.littlelemon.littlelemon.ui.theme.LLDark
import com.littlelemon.littlelemon.ui.theme.LLYellow

@Composable
fun MenuItems(
    products: List<ProductItem>,
    categories: List<String>,
    selectedCategory: String?,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "ORDER FOR DELIVERY!",
            color = LLDark,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 8.dp
            )
        )

        HorizontalDivider()

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                AssistChip(
                    onClick = {
                        onCategorySelected(category)
                    },
                    label = {
                        Text(
                            text = category.replaceFirstChar { it.uppercase() },
                            color = LLDark,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = if (selectedCategory == category) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            }
                        )
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedCategory == category) {
                            LLYellow
                        } else {
                            LLCloud
                        },
                        labelColor = LLDark
                    )
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) { productItem ->
                ProductCard(productItem = productItem)
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemsPreview() {
    val previewProducts = listOf(
        ProductItem(
            title = "Greek Salad",
            price = "10",
            category = "starters",
            description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true"
        ),
        ProductItem(
            title = "Lemon Dessert",
            price = "10",
            category = "desserts",
            description = "Traditional homemade Italian Lemon Ricotta Cake.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/lemonDessert%202.jpg?raw=true"
        ),
        ProductItem(
            title = "Pasta",
            price = "10",
            category = "mains",
            description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chili, garlic, basil and salted ricotta cheese.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/pasta.jpg?raw=true"
        )
    )

    MenuItems(
        products = previewProducts,
        categories = previewProducts.map { it.category }.distinct(),
        selectedCategory = null,
        onCategorySelected = {}
    )
}