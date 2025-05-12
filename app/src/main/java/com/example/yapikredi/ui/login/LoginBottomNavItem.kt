package com.example.yapikredi.ui.login

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.yapikredi.R

sealed class LoginBottomNavItem<T>(val name: String, val route: String, private val icon: T) {
    data object Fast : LoginBottomNavItem<Int>("FAST İŞLEMLERİ", "fast_transactions", R.drawable.ic_fast)
    data object Market : LoginBottomNavItem<Int>("PİYASALAR", "market", R.drawable.ic_arrow_up)
    data object QR : LoginBottomNavItem<ImageVector>("JET QR", "jet_qr", Icons.Default.Settings)
    data object Pay : LoginBottomNavItem<Int>("WORLD PAY", "world_pay", R.drawable.ic_pay)
    data object More : LoginBottomNavItem<ImageVector>("DAHA FAZLASI", "more", Icons.Default.Menu)

    @Composable
    fun getIcon(): ImageVector{
        return when(icon) {
            is ImageVector -> icon
            is Int -> ImageVector.vectorResource(id = icon)
            else -> throw IllegalArgumentException("Icon type not supported")
        }
    }
}