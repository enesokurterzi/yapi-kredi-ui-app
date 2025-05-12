package com.example.yapikredi.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
internal fun MainRoute(paddingValues: PaddingValues) {
    MainScreen(paddingValues)
}

@Composable
private fun MainScreen(paddingValues: PaddingValues) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val horizontalPadding = 16.dp

    val localDensity = LocalDensity.current
    var columnHeightDp by remember { mutableStateOf(0.dp) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(Modifier.padding(paddingValues)) {
                Spacer(Modifier.height(4.dp))
                MainTopBar(modifier = Modifier.padding(horizontal = horizontalPadding)) { searchText ->
                    // Handle search text change
                }

            }
        }
    ) { innerPadding ->
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(columnHeightDp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF1287DE),
                                        Color(0xFF84D1FB),
                                    )
                                ),
                                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                            )
                    ) {
                    }

                    Box {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(
                                    PaddingValues(
                                        start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                                        end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                                        top = innerPadding.calculateTopPadding() - 8.dp,
                                        bottom = innerPadding.calculateBottomPadding()
                                    )
                                ),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Column(
                                modifier = Modifier.onGloballyPositioned { coordinates ->
                                    columnHeightDp =
                                        with(localDensity) { coordinates.size.height.toDp() + innerPadding.calculateTopPadding() - 87.dp }
                                }
                            ) {
                                CustomTabRow(
                                    modifier = Modifier.padding(horizontal = horizontalPadding),
                                    selectedTabIndex
                                ) { tabSelected ->
                                    selectedTabIndex = tabSelected
                                }
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.Top,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    when (selectedTabIndex) {
                                        0 -> YapiKrediTab(horizontalPadding = horizontalPadding)
                                        1 -> OtherCardsTab(horizontalPadding = horizontalPadding)
                                    }
                                }
                            }

                            BottomContent(horizontalPadding = horizontalPadding)

                        }

                    }

                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun InfoScreenPreview() {
    MainScreen(PaddingValues())
}