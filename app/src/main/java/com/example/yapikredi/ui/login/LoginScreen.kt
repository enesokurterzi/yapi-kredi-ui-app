package com.example.yapikredi.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yapikredi.R

@Composable
internal fun LoginRoute(paddingValues: PaddingValues, onPasswordCorrect: () -> Unit) {
    LoginScreen(paddingValues, onPasswordCorrect)
}

@Composable
private fun LoginScreen(paddingValues: PaddingValues, onPasswordCorrect: () -> Unit) {
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        bottomBar = {
            LoginBottomNavigation(
                items = listOf(
                    LoginBottomNavItem.Fast,
                    LoginBottomNavItem.Market,
                    LoginBottomNavItem.QR,
                    LoginBottomNavItem.Pay,
                    LoginBottomNavItem.More,
                )
            ) {
                // Can be added
            }
        },
        floatingActionButton = {
            Column(
                modifier = Modifier.offset(y = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                FloatingActionButton(
                    onClick = { /* stub */ },
                    shape = RoundedCornerShape(16.dp),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    containerColor = Color.White,
                    modifier = Modifier
                        .size(60.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.primary),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            tint = Color.White,
                            painter = painterResource(R.drawable.ic_qr),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Text("JET QR", color = Color.Gray, fontSize = 9.sp)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { contentPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(contentPadding)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Outlined.AccountCircle,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                    BadgedBox(
                        badge = {
                            Badge {
                                Text(text = "3")
                            }
                        }
                    ) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notifications",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(28.dp),
                    painter = painterResource(id = R.drawable.ic_splash),
                    contentDescription = "Splash Icon"
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.size(128.dp)
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "AccountCircle",
                        modifier = Modifier
                            .size(128.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.White, CircleShape)
                    )
                    Icon(
                        tint = Color.White,
                        imageVector = ImageVector.vectorResource(R.drawable.ic_hand_point_up),
                        contentDescription = "Badge Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.BottomEnd)
                            .offset((-9).dp, (-9).dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondary)
                            .padding(2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text("İyi Günler, Enes Okurterzi", fontSize = 18.sp, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                LoginPasswordTextField (onPasswordCorrect = onPasswordCorrect)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Şifremi Unuttum",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
            LazyRow(
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
            ) {
                items(bottomRowItems) { item ->
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                            .width(150.dp)
                            .height(100.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .size(42.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = "Splash Icon"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            lineHeight = 14.sp,
                            textAlign = TextAlign.Start,
                            text = item.title,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun InfoScreenPreview() {
    LoginScreen(PaddingValues(), {})
}