package com.littlelemon.littlelemon.components.menuitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.littlelemon.littlelemon.components.menuitems.model.ProductItem

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(
    productItem: ProductItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = productItem.title,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = productItem.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(
                    text = formatPrice(productItem.price),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            GlideImage(
                model = productItem.image,
                contentDescription = productItem.title,
                modifier = Modifier.size(90.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}


private fun formatPrice(price: String): String {
    return price
        .toDoubleOrNull()
        ?.let { "$%.2f".format(it) }
        ?: "$$price"
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        productItem = ProductItem(
            title = "Greek Salad",
            price = "10",
            category = "starters",
            description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true"
        )
    )
}