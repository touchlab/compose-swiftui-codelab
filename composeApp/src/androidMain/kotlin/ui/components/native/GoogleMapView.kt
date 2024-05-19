package ui.components.native

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import data.MapCoordinates

@Composable
fun GoogleMapView(
    modifier: Modifier,
    placeName: String,
    coordinate: MapCoordinates
) {
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(coordinate.lat, coordinate.lng), 14f)
    }

    LaunchedEffect(coordinate) {
        cameraPosition.position =
            CameraPosition.fromLatLngZoom(LatLng(coordinate.lat, coordinate.lng), 14f)
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPosition,
        uiSettings = MapUiSettings(
            compassEnabled = false,
            indoorLevelPickerEnabled = false,
            mapToolbarEnabled = false,
            myLocationButtonEnabled = false,
            rotationGesturesEnabled = false,
            scrollGesturesEnabled = false,
            scrollGesturesEnabledDuringRotateOrZoom = false,
            tiltGesturesEnabled = false,
            zoomControlsEnabled = false,
            zoomGesturesEnabled = false,
        )
    ) {
        Marker(
            state = MarkerState(LatLng(coordinate.lat, coordinate.lng)),
            title = placeName,
        )
    }
}