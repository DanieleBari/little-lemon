import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
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
    Column {
        Header(navController)
        Hero()
        MenuItems(products = products)
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