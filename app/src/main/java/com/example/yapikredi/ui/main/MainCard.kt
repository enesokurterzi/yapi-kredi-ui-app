package com.example.yapikredi.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R
import com.example.yapikredi.extension.shimmerEffect

@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    mainCardData: MainCardData,
    isLoading: Boolean = false
) {
    Card(
        modifier = modifier
            .height(128.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        if (isLoading) {
            Row(
                modifier = Modifier
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                ) {
                    Row(
                        modifier = Modifier.height(48.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .shimmerEffect(),
                        ) {}
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxHeight()
                                .weight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                modifier = Modifier
                                    .width(128.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = Modifier
                                    .width(64.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                        }
                        Icon(
                            modifier = Modifier.clip(RoundedCornerShape(4.dp)).shimmerEffect(),
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Options",
                            tint = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .width(64.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                modifier = Modifier
                                    .width(128.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                        }
                        VerticalDivider(modifier = Modifier
                            .padding(8.dp)
                            .shimmerEffect())
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .width(64.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                modifier = Modifier
                                    .width(128.dp)
                                    .height(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmerEffect(),
                                text = "",
                            )
                        }
                    }
                }
            }
        } else {
            Row(
                modifier = Modifier
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(5.dp)
                        .background(mainCardData.color)
                ) { }
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                ) {
                    Row(
                        modifier = Modifier.height(48.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(52.dp),
                            contentScale = ContentScale.FillBounds,
                            painter = painterResource(id = mainCardData.image),
                            contentDescription = "Card Icon"
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxHeight()
                                .weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = mainCardData.title,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black
                            )
                            Text(
                                text = mainCardData.number,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Options",
                            tint = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = mainCardData.firstAmount,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black
                            )
                            Text(
                                text = mainCardData.firstDescription,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                            )
                        }
                        VerticalDivider(modifier = Modifier.padding(8.dp))
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = mainCardData.secondAmount,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.Black
                            )
                            Text(
                                text = mainCardData.secondDescription,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun MainCardPreview() {
    val mainCardData = MainCardData(
        color = colorResource(R.color.cooks_bay),
        image = R.drawable.ic_card,
        title = "Vadesiz TL Hesabı",
        number = "111111111",
        firstAmount = "10.000,00",
        firstDescription = "Kullanılabilir Bakiye",
        secondAmount = "5.000,00",
        secondDescription = "Güncel Bakiye"
    )
    MainCard(
        mainCardData = mainCardData
    )
}

@Composable
@Preview
private fun MainCardPreview2() {
    val mainCardData = MainCardData(
        color = colorResource(R.color.cooks_bay),
        image = R.drawable.ic_card,
        title = "Vadesiz TL Hesabı",
        number = "111111111",
        firstAmount = "10.000,00",
        firstDescription = "Kullanılabilir Bakiye",
        secondAmount = "5.000,00",
        secondDescription = "Güncel Bakiye"
    )
    MainCard(
        mainCardData = mainCardData,
        isLoading = true
    )
}

data class MainCardData(
    val color: Color,
    val image: Int,
    val title: String,
    val number: String,
    val firstAmount: String,
    val firstDescription: String,
    val secondAmount: String,
    val secondDescription: String
)