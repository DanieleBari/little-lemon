import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.components.Header
import com.littlelemon.littlelemon.components.Hero
import com.littlelemon.littlelemon.components.MenuItems
import com.littlelemon.littlelemon.components.menuitems.model.ProductItem


@Composable
fun Home(
    navController: NavHostController? = null,
    products: List<ProductItem>
) {
    var searchPhrase by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    val categories = products
        .map { it.category }
        .distinct()

    val filteredProducts = products
        .filter { product ->
            val matchesSearchPhrase =
                searchPhrase.isBlank() ||
                        product.title.contains(searchPhrase, ignoreCase = true) ||
                        product.description.contains(searchPhrase, ignoreCase = true)

            val matchesCategory =
                selectedCategory == null ||
                        product.category.equals(selectedCategory, ignoreCase = true)

            matchesSearchPhrase && matchesCategory
        }
        .sortedBy { product ->
            product.title.lowercase()
        }

    Column {
        Header(navController)

        Hero(
            searchPhrase = searchPhrase,
            onSearchPhraseChange = { searchPhrase = it }
        )

        MenuItems(
            products = filteredProducts,
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { category ->
                selectedCategory = if (selectedCategory == category) {
                    null
                } else {
                    category
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home(
        null,
        emptyList()
    )
}