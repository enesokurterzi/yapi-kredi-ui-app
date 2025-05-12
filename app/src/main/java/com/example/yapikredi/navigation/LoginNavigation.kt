package com.example.yapikredi.navigation

import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.yapikredi.ui.login.LoginRoute

const val loginRoute = "login_route"
fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.popBackStack()
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(paddingValues: PaddingValues, onPasswordCorrect: () -> Unit) {
    composable(
        route = loginRoute,
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it })
        }
    ) {
        LoginRoute(paddingValues, onPasswordCorrect)
    }
}