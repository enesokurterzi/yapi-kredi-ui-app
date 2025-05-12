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
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yapikredi.R

@Composable
fun MainOtherCard(
    modifier: Modifier = Modifier,
    mainOtherCardData: MainOtherCardData
) {
    Card(
        modifier = modifier
            .height(128.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = mainOtherCardData.image),
                    contentDescription = null,
                    tint = Color(0xFF1287DE),
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = mainOtherCardData.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
            }
            if (!mainOtherCardData.isButton) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF1F5F9))
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = mainOtherCardData.buttonText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF1287DE),
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                        contentDescription = "Right Arrow",
                        tint = Color(0xFF1287DE),
                        modifier = Modifier.size(20.dp)
                    )

                }
            } else {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0587D8),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text(
                        text = mainOtherCardData.buttonText,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun MainCardPreview() {
    val mainCardData = MainOtherCardData(
        image = R.drawable.ic_assets,
        description = "Diğer banka/kurum hesaplarınızı ekleyerek varlıklarınızı takip edebilir, size özel öneri ve tekliflerden faydalanabilirsiniz.",
        isButton = false,
        buttonText = "Bankam+ için tıklayınız"
    )
    MainOtherCard(
        mainOtherCardData = mainCardData
    )
}

@Composable
@Preview
private fun MainCardPreview2() {
    val mainCardData = MainOtherCardData(
        image = R.drawable.ic_assets,
        description = "Diğer banka/kurum hesaplarınızı ekleyerek varlıklarınızı takip edebilir, size özel öneri ve tekliflerden faydalanabilirsiniz.",
        isButton = true,
        buttonText = "Hesap/Banka Ekle"
    )
    MainOtherCard(
        mainOtherCardData = mainCardData
    )
}

data class MainOtherCardData(
    val image: Int,
    val description: String,
    val isButton: Boolean,
    val buttonText: String,
)