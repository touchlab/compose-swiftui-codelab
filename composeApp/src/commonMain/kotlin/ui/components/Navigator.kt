package ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.jetpack.ProvideNavigatorLifecycleKMPSupport
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ui.screen.list.ListScreen

@OptIn(ExperimentalVoyagerApi::class)
@Composable
internal fun AppNavigator() {
    ProvideNavigatorLifecycleKMPSupport {
        Navigator(ListScreen()) { navigator ->
            Scaffold(
                topBar = {
                    TopBar(navigator)
                },
                content = { padding ->
                    SlideTransition(
                        navigator = navigator,
                        modifier = Modifier.padding(padding)
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(navigator: Navigator) {
    CenterAlignedTopAppBar(
        title = {
            HeaderText()
        },
        navigationIcon = {
            AnimatedVisibility(
                navigator.size > 1,
                enter = scaleIn(),
                exit = scaleOut(),
            ) {
                IconButton(
                    onClick = { navigator.pop() },
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go back",
                    )
                }
            }
        }
    )
}
