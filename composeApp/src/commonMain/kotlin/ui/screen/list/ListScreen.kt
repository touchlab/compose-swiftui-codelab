package ui.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.Restaurant
import datasource.LocalRestaurantsDataSource
import ui.components.Label
import ui.screen.detail.DetailScreen

class ListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = viewModel { ListViewModel(LocalRestaurantsDataSource) }
        ListScreenContent(
            modifier = Modifier.fillMaxSize(),
            viewModel = viewModel,
            onRestaurantClick = { restaurant ->
                navigator.push(DetailScreen(restaurant))
            }
        )
    }
}

@Composable
internal expect fun ListScreenContent(
    modifier: Modifier,
    viewModel: ListViewModel,
    onRestaurantClick: (Restaurant) -> Unit
)

@Composable
internal fun ListScreenContentCompose(
    modifier: Modifier,
    viewModel: ListViewModel,
    onRestaurantClick: (Restaurant) -> Unit
) {
    val restaurants by viewModel.restaurants.collectAsState()

    LazyColumn(modifier = modifier) {
        items(restaurants) { restaurant ->
            RestaurantListItem(
                restaurant = restaurant,
                onClick = { onRestaurantClick(restaurant) }
            )
        }
    }
}

@Composable
private fun RestaurantListItem(
    restaurant: Restaurant,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainerLow,
            )
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            Icons.Filled.Place,
            contentDescription = null,
            modifier = Modifier.size(54.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.width(6.dp))

        Column {
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.titleMedium
            )
            Label(
                text = restaurant.category,
            )
        }

        Spacer(Modifier.weight(1f))

        Icon(
            Icons.Filled.ChevronRight,
            contentDescription = null,
            modifier = Modifier.size(28.dp),
        )
    }
}
