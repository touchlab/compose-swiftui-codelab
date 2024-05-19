package ui.components.native

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.MapCoordinates

@Composable
actual fun MapView(
    modifier: Modifier,
    placeName: String,
    coordinate: MapCoordinates
) {
    GoogleMapView(
        modifier = modifier,
        placeName = placeName,
        coordinate = coordinate,
    )
}