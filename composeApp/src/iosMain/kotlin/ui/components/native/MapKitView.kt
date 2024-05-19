package ui.components.native

import LocalNativeViewFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import data.MapCoordinates

@Composable
internal fun MapKitView(
    modifier: Modifier,
    placeName: String,
    coordinate: MapCoordinates
) {
    UIKitViewController(
        modifier = modifier,
        factory = { TODO("Call view controller factory") },
    )
}