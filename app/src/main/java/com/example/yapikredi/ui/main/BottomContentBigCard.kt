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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.yapikredi.R

@Composable
fun BottomContentBigCard(modifier: Modifier = Modifier, cardHeight: Dp, item: BottomContentItem) {
    Card(
        modifier = modifier.height(cardHeight),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "YENİ",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .background(
                            Color(0xFFFF5722),
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 6.dp,
                                bottomEnd = 6.dp
                            )
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .padding(top = 12.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(
                    start = 8.dp,
                    top = 8.dp,
                    bottom = 8.dp,
                    end = 24.dp
                ),
            ) {
                Image(
                    modifier = Modifier
                        .size(58.dp),
                    painter = painterResource(id = item.icon),
                    contentDescription = "Splash Icon",
                )
                Text(
                    item.title,
                    maxLines = 3,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Hemen Keşfet",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF0587D8)
                )
            }
        }

    }
}

@Composable
@Preview
fun BottomContentBigCardPreview() {
    BottomContentBigCard(
        cardHeight = 128.dp,
        item = BottomContentItem(
            "Ev, araç ve hayatınızı kolaylaştıran diğer ihtiyaçlarınız için",
            R.drawable.ic_card,
            isNew = false
        )
    )
}