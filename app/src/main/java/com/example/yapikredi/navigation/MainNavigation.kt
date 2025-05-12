package com.example.yapikredi.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yapikredi.ui.main.MainRoute

const val mainRoute = "main_route"
fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.popBackStack()
    this.navigate(mainRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(paddingValues: PaddingValues) {
    composable(
        route = mainRoute,
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it })
        }
    ) {
        MainRoute(paddingValues)
    }
}