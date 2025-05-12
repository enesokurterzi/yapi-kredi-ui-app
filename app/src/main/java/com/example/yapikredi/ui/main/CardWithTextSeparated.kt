package com.example.yapikredi.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun CardWithTextSeparated(
    modifier: Modifier = Modifier,
    iconReduceSize: Dp = 0.dp,
    elevation: Dp,
    description: String,
    icon: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(elevation)
        ) {
            Image(
                modifier = Modifier
                    .padding(
                        start = 8.dp + (iconReduceSize / 2),
                        end = 8.dp + (iconReduceSize / 2),
                        top = 8.dp + (iconReduceSize / 2) - (iconReduceSize / 4),
                        bottom = 8.dp + (iconReduceSize / 2) + (iconReduceSize / 4)
                    )
                    .size(32.dp - iconReduceSize),
                painter = painterResource(id = icon),
                contentDescription = "Splash Icon"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(78.dp)
        ) {
            Text("", minLines = 2)
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                maxLines = 3,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun CardWithTextPreview() {
    CardWithTextSeparated(
        description = "Varlıklarım",
        elevation = 8.dp,
        icon = R.drawable.ic_assets
    )
}