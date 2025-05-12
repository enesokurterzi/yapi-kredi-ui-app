package com.example.yapikredi.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.yapikredi.R

@Composable
fun CustomTabRow(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("Yapı Kredi", "Diğer Bankalarım")

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
            .height(32.dp)
            .clip(RoundedCornerShape(24.dp)),
        containerColor = colorResource(R.color.wasurenagusa_blue),
        indicator = { tabPositions ->
            SecondaryIndicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(24.dp))
                    .zIndex(-1f),
                color = Color.White,
            )
        },
        divider = {}
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { },
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(24.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(null, null) { onTabSelected(index) },
                    text = title,
                    textAlign = TextAlign.Center,
                    color = if (selectedTabIndex == index) colorResource(R.color.spanish_blue) else Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Preview
@Composable
private fun CustomTabRowPreview() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    CustomTabRow(
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { selectedTabIndex = it }
    )
}