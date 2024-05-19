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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import cafe.adriel.voyager.core.lifecycle.LocalNavigatorScreenLifecycleProvider
import cafe.adriel.voyager.core.lifecycle.NavigatorScreenLifecycleProvider
import cafe.adriel.voyager.core.lifecycle.ScreenLifecycleContentProvider
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ui.screen.list.ListScreen

@Composable
internal fun AppNavigator() {
    val viewModelOwnerProvider = remember { ViewModelNavigatorScreenLifecycleProvider() }
    CompositionLocalProvider(LocalNavigatorScreenLifecycleProvider provides viewModelOwnerProvider) {
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

// Voyager support for Androidx ViewModel
internal class ViewModelNavigatorScreenLifecycleProvider : NavigatorScreenLifecycleProvider {
    override fun provide(screen: Screen): List<ScreenLifecycleContentProvider> =
        listOf(ViewModelScreenLifecycleContentProvider(screen))
}

class ViewModelScreenLifecycleContentProvider(
    private val screen: Screen
) : ScreenLifecycleContentProvider {
    @Composable
    override fun ProvideBeforeScreenContent(
        provideSaveableState: @Composable (suffixKey: String, content: @Composable () -> Unit) -> Unit,
        content: @Composable () -> Unit
    ) {
        val viewModelStoreOwner = screen.rememberScreenModel { ViewModelStoreScreenModel() }
        CompositionLocalProvider(LocalViewModelStoreOwner provides viewModelStoreOwner) {
            content()
        }
    }
}

@PublishedApi
internal class ViewModelStoreScreenModel : ScreenModel, ViewModelStoreOwner {

    override val viewModelStore: ViewModelStore = ViewModelStore()

    override fun onDispose() {
        super.onDispose()
        viewModelStore.clear()
    }
}