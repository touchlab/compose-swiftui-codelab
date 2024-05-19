package ui.screen.list

import LocalNativeViewFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import data.Restaurant

@Composable
internal actual fun ListScreenContent(
    modifier: Modifier,
    viewModel: ListViewModel,
    onRestaurantClick: (Restaurant) -> Unit
) {
    val factory = LocalNativeViewFactory.current

    UIKitViewController(
        modifier = modifier,
        factory = { factory.createListScreenView(viewModel, onRestaurantClick) }
    )
}