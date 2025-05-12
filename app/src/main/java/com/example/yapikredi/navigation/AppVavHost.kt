package com.example.yapikredi.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppVavHost(
    paddingValues: PaddingValues,
    startDestination: String = splashRoute,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController,
        startDestination = startDestination,
    ) {
        splashScreen(paddingValues, navigateToLogin = navController::navigateToLogin)
        loginScreen(paddingValues, onPasswordCorrect = navController::navigateToMain)
        mainScreen(paddingValues)
    }
}