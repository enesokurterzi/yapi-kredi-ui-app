package com.example.yapikredi.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R

@Composable
fun OtherCardsTab(modifier: Modifier = Modifier, horizontalPadding: Dp) {
    val state = rememberLazyListState()

    val mainCardAssetsData = MainOtherCardData(
        image = R.drawable.ic_assets,
        description = "Diğer banka/kurum hesaplarınızı ekleyerek varlıklarınızı takip edebilir, size özel öneri ve tekliflerden faydalanabilirsiniz.",
        isButton = false,
        buttonText = "Bankam+ için tıklayınız"
    )

    val mainCardAccountsData = MainOtherCardData(
        image = R.drawable.ic_purse,
        description = "Diğer banka/kurum hesaplarınızı ekleyerek varlıklarınızı takip edebilir, size özel öneri ve tekliflerden faydalanabilirsiniz.",
        isButton = true,
        buttonText = "Hesap/Banka Ekle"
    )

    val bottomCardItems = listOf(
        "Hesap\nEkle" to R.drawable.ic_plus,
        "Son Hareketler" to R.drawable.ic_arrow_left_right,
        "Başka Bankadan Para Getir" to R.drawable.ic_money,
        "Kendi Kredi Kartıma Borç Öde" to R.drawable.ic_pay_blue
    )

    val bottomCardElevation = 8.dp

    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            text = "Diğer Banka Varlıklarım",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        MainOtherCard(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            mainOtherCardData = mainCardAssetsData
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            text = "Diğer Banka Hesaplarım",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(12.dp))
        MainOtherCard(
            modifier = Modifier.padding(horizontal = horizontalPadding),
            mainOtherCardData = mainCardAccountsData
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding + 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            bottomCardItems.forEach { (description, icon) ->
                CardWithTextSeparated(
                    elevation = bottomCardElevation,
                    description = description,
                    icon = icon
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1287DE)
@Composable
private fun YapiKrediTabPreview() {
    OtherCardsTab(horizontalPadding = 16.dp)
}