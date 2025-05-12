package com.example.yapikredi.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginBottomNavigation(
    items: List<LoginBottomNavItem<out Any>>,
    onItemClick: () -> Unit, // Can be modified
) {
    NavigationBar(
        windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            val isMiddleItem = index == items.size / 2
            NavigationBarItem(
                selected = false, // Can be modified
                onClick = { onItemClick.invoke() },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Magenta,
                    unselectedIconColor = Color.Gray
                ),
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (isMiddleItem) {
                            Spacer(modifier = Modifier.height(24.dp))
                        } else {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = item.getIcon(),
                                contentDescription = item.name,
                            )
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 9.sp
                            )
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun LoginBottomNavigationPreview() {
    LoginBottomNavigation(
        items = listOf(
            LoginBottomNavItem.Fast,
            LoginBottomNavItem.Market,
            LoginBottomNavItem.QR,
            LoginBottomNavItem.Pay,
            LoginBottomNavItem.More,
        ),
        onItemClick = {}
    )
}