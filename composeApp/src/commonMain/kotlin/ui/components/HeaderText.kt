package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun HeaderText(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.extraSmall,
            )
    ) {
        Text(
            text = "Restaurants",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}
