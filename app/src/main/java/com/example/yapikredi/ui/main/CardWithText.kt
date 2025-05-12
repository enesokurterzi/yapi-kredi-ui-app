package com.example.yapikredi.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.yapikredi.R

@Composable
fun CardWithText(modifier: Modifier = Modifier, elevation: Dp, cardHeight: Dp, item: BottomContentItem) {
    Column (
        modifier = modifier
    ){
        if (item.isNew) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .offset(y = 7.dp)
                    .zIndex(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Yeni",
                    color = Color.White,
                    lineHeight = 12.sp,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 8.sp),
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFF5722),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 10.dp)
                )
            }
        } else {
            Spacer(modifier = Modifier.height(12.dp))
        }
        Card(
            modifier = Modifier.height(cardHeight),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(elevation)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(32.dp),
                    painter = painterResource(id = item.icon),
                    contentDescription = "Splash Icon"
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    lineHeight = 12.sp,
                    maxLines = 2,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

@Preview
@Composable
private fun CardWithTextPreview() {
    CardWithText(elevation = 4.dp, cardHeight = 64.dp, item = BottomContentItem("Step", R.drawable.ic_card, isNew = true),)
}