package com.example.yapikredi.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yapikredi.ui.splash.SplashRoute

const val splashRoute = "splash_route"
fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.navigate(splashRoute, navOptions)
}

fun NavGraphBuilder.splashScreen(paddingValues: PaddingValues, navigateToLogin: () -> Unit) {
    composable(route = splashRoute) {
        SplashRoute(paddingValues, navigateToLogin)
    }
}