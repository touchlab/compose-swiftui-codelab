package ui.screen.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.Restaurant

@Composable
internal actual fun ListScreenContent(
    modifier: Modifier,
    viewModel: ListViewModel,
    onRestaurantClick: (Restaurant) -> Unit
) {
    ListScreenContentCompose(
        modifier = modifier,
        viewModel = viewModel,
        onRestaurantClick = onRestaurantClick,
    )
}