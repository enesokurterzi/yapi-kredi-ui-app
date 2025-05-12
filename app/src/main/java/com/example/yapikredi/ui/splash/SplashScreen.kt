package com.example.yapikredi.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R
import kotlinx.coroutines.delay

@Composable
internal fun SplashRoute(paddingValues: PaddingValues, navigateToLogin: () -> Unit) {
    SplashScreen(paddingValues, navigateToLogin)
}

@Composable
private fun SplashScreen(paddingValues: PaddingValues, navigateToLogin: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1000L)
        navigateToLogin.invoke()
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(48.dp),
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = "Splash Icon"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(PaddingValues()) {}
}