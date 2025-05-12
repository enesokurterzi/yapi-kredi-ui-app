package com.example.yapikredi.ui.main

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R

@Composable
fun YapiKrediTab(modifier: Modifier = Modifier, horizontalPadding: Dp) {
    val state = rememberLazyListState()
    val myAccountsCardData = MainCardData(
        color = colorResource(R.color.cooks_bay),
        image = R.drawable.ic_card,
        title = "Vadesiz TL Hesabı",
        number = "111111111",
        firstAmount = "10.000,00",
        firstDescription = "Kullanılabilir Bakiye",
        secondAmount = "1.155.000,00",
        secondDescription = "Güncel Bakiye"
    )

    val cardsCardData = listOf(
        MainCardData(
            color = colorResource(R.color.her_highness),
            image = R.drawable.ic_card,
            title = "Hepsiburada WorldCard",
            number = "111111111",
            firstAmount = "20.000,00",
            firstDescription = "Güncel Dönem Borcu",
            secondAmount = "10.000,00",
            secondDescription = "Kullanılabilir Limit"
        ),
        MainCardData(
            color = colorResource(R.color.golden_samovar),
            image = R.drawable.ic_card,
            title = "Opet WorldCard",
            number = "111111111",
            firstAmount = "25.000,00",
            firstDescription = "Güncel Dönem Borcu",
            secondAmount = "15.000,00",
            secondDescription = "Kullanılabilir Limit"
        )
    )

    val bottomCardItems = listOf(
        "Varlıklarım" to R.drawable.ic_assets,
        "Para Çek/ Yatır" to R.drawable.ic_qr_main,
        "Son Hareketler" to R.drawable.ic_arrow_left_right,
        "Aylık Ödeme Planım" to R.drawable.ic_calender
    )

    val bottomCardElevation = 8.dp

    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            text = "Hesaplarım",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        MainCard(
            modifier = modifier.padding(horizontal = horizontalPadding),
            mainCardData = myAccountsCardData
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            text = "Kartlarım",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state),
            state = state
        ) {
            items(cardsCardData) { cardData ->
                MainCard(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .fillParentMaxWidth(0.958f),
                    mainCardData = cardData
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding + 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            bottomCardItems.forEachIndexed { index, pair ->
                if (index == 3) {
                    CardWithTextSeparated(
                        iconReduceSize = 8.dp,
                        elevation = bottomCardElevation,
                        description = pair.first,
                        icon = pair.second
                    )
                } else {
                    CardWithTextSeparated(
                        elevation = bottomCardElevation,
                        description = pair.first,
                        icon = pair.second
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1287DE)
@Composable
private fun YapiKrediTabPreview() {
    YapiKrediTab(horizontalPadding = 16.dp)
}