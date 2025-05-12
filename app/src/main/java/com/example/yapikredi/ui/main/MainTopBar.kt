package com.example.yapikredi.ui.main

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yapikredi.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    onSearchTextChanged: (String) -> Unit,
) {
    var value by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember { FocusRequester() }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .focusRequester(focusRequester)
                .focusTarget(),
            value = value,
            onValueChange = {
                value = it
                onSearchTextChanged(it)
            },
            maxLines = 1,
            textStyle = TextStyle(
                textAlign = TextAlign.Start,
                color = Color.White,
            ),
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            decorationBox = { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    singleLine = true,
                    enabled = true,
                    visualTransformation = VisualTransformation.None,
                    placeholder = {
                        if (!isPressed && !isFocused) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text = "Yapı Kredi Mobil'de Ara",
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.wasurenagusa_blue),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    },
                    interactionSource = interactionSource,
                    contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                        top = 0.dp, bottom = 0.dp
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = colorResource(R.color.spanish_blue),
                        unfocusedContainerColor = colorResource(R.color.spanish_blue),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                        Row(
                            modifier = Modifier.fillMaxWidth(0.15f),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Default.Menu,
                                contentDescription = "More",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    },
                    trailingIcon = {
                        Row {
                            BadgedBox(
                                badge = {
                                    Badge {
                                        Text(text = "3")
                                    }
                                }
                            ) {
                                Icon(
                                    tint = Color.White,
                                    imageVector = Icons.Outlined.Notifications,
                                    contentDescription = "Notifications",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            Spacer(Modifier.width(4.dp))
                            Icon(
                                tint = Color.White,
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = "Notifications",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                        }
                    },
                )
            }
        )
    }
}

@Composable
@Preview
private fun MainTopBar2Preview() {
    MainTopBar() { searchText ->
        // Handle search text change
    }
}