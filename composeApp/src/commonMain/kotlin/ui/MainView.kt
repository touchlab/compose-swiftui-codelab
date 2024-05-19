package ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import ui.components.AppNavigator

@Composable
fun MainView() {
    MaterialTheme {
        AppNavigator()
    }
}
