package com.example.yapikredi.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R

@Composable
fun BottomContent(horizontalPadding: Dp) {
    val items = listOf(
        BottomContentItem(
            "Ev, araç ve hayatınızı kolaylaştıran diğer ihtiyaçlarınız için",
            R.drawable.ic_heart,
            isNew = false
        ),
        BottomContentItem("Evim+", R.drawable.ic_house, isNew = false),
        BottomContentItem("Aracım+", R.drawable.ic_car, isNew = false),
        BottomContentItem("Bankam+", R.drawable.ic_building, isNew = false),
        BottomContentItem("Seyahatim+", R.drawable.ic_baggage, isNew = false),
        BottomContentItem("Maaşım+", R.drawable.ic_purse, isNew = true),
        BottomContentItem("World PAY", R.drawable.ic_pay_blue, isNew = false),
        BottomContentItem("Step", R.drawable.ic_letter_s, isNew = false),
        BottomContentItem("Chippin", R.drawable.ic_letter_c, isNew = false),
        BottomContentItem("Seyahat Planla", R.drawable.ic_letter_s, isNew = true),
        BottomContentItem("Araç\n Kirala", R.drawable.ic_letter_a, isNew = false),
        BottomContentItem("Araçta\n Öde", R.drawable.ic_letter_o, isNew = false),
        BottomContentItem("Dijital\n Kodlar", R.drawable.ic_play, isNew = false)
    )

    val bottomCardItems = listOf(
        "Akıllı\nRehber" to R.drawable.ic_assets,
        "Akıllı\n Asistan" to R.drawable.ic_qr_main,
        "Akıllı\n Borsacım" to R.drawable.ic_arrow_left_right,
        "Kampanyalar" to R.drawable.ic_calender
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Benim Dünyam",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(
                bottom = 4.dp,
                top = 32.dp,
                start = horizontalPadding,
                end = horizontalPadding
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(bottom = 6.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items.take(1).forEach { item ->
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Spacer(Modifier.height(12.dp))
                        BottomContentBigCard(
                            cardHeight = 162.dp,
                            item = item
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items.drop(1).take(2).forEach { item ->
                            CardWithText(
                                modifier = Modifier
                                    .weight(1f),
                                elevation = 4.dp,
                                cardHeight = 72.dp,
                                item = item,
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items.drop(3).take(2).forEach { item ->
                            CardWithText(
                                modifier = Modifier
                                    .weight(1f),
                                elevation = 4.dp,
                                cardHeight = 72.dp,
                                item = item
                            )
                        }
                    }
                }
            }

            for (rowIndex in 0 until (items.size - 6 + 3) / 4) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items.drop(5 + rowIndex * 4).take(4).forEach { item ->
                        CardWithText(
                            modifier = Modifier
                                .weight(1f),
                            elevation = 4.dp,
                            cardHeight = 72.dp,
                            item = item
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF4F5F8))
                .padding(horizontal = horizontalPadding, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            bottomCardItems.forEach { (title, icon) ->
                CardWithTextSeparated(
                    elevation = 4.dp,
                    description = title,
                    icon = icon
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF3F5F8))
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock",
                            tint = Color(0xFF1287DE),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Son Başarılı Giriş",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                    Text(
                        text = "06/05/2025 19:17",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock",
                            tint = Color(0xFF93A7C3),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Son Başarısız Giriş",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                    Text(
                        text = "04/05/2025 18:34", // Tarih ve saat
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }
            }
            Icon(
                imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                contentDescription = "Right Arrow",
                tint = Color(0xFF1287DE),
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BottomContentPreview() {
    BottomContent(16.dp)
}

data class BottomContentItem(
    val title: String,
    val icon: Int,
    val isNew: Boolean = false
)