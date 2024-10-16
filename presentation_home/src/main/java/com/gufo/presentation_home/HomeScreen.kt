package com.gufo.presentation_home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gufo.presentation_composable.AppText
import com.gufo.presentation_composable.Container
import com.gufo.presentation_composable.FWeight
import com.gufo.presentation_composable.TextSize
import com.gufo.presentation_composable.bg
import com.gufo.presentation_composable.containerBg
import com.gufo.presentation_composable.dashedBorder
import com.gufo.presentation_composable.dottedBorder
import com.gufo.presentation_composable.gray
import com.gufo.presentation_composable.primaryCorner
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.primaryCornerTop
import com.gufo.presentation_composable.textColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onNavigate: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
    ) {

        Container(weight = .4f, align = Alignment.Center) {
            Box(modifier = Modifier.fillMaxWidth(.9f), contentAlignment = Alignment.CenterStart) {
                AppText(
                    value = "Создать баннер",
                    textSize = TextSize.LARGE,
                    fontWeight = FWeight.BOLD,
                    color = textColor
                )
            }
        }

        Container(weight = 1f) {
            Box(
                modifier = Modifier
                    .clip(primaryCornerFull.invoke())
                    .fillMaxWidth(.9f)
                    .height(180.dp)
                    .dashedBorder(3.dp, gray.copy(.6f), 35.dp)
                    .clickable { onNavigate() },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    tint = gray.copy(.6f)
                )
            }
        }

        Container(weight = 2f) {
            Box(
                modifier = Modifier
                    .clip(primaryCornerTop.invoke())
                    .fillMaxSize()
                    .background(containerBg),
                contentAlignment = Alignment.Center,
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize(.9f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    stickyHeader {
                        Box(modifier = Modifier.fillParentMaxWidth(), contentAlignment = Alignment.CenterStart) {
                            AppText(
                                value = "Шаблоны",
                                textSize = TextSize.MEDIUM,
                                fontWeight = FWeight.BOLD,
                                color = textColor
                            )
                        }
                    }

                    items(10) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(primaryCornerFull.invoke())
                                    .width(150.dp)
                                    .height(100.dp)
                                    .background(gray),
                                contentAlignment = Alignment.Center,
                            ) {
                                AppText(
                                    value = it.toString(),
                                    textSize = TextSize.MEDIUM,
                                    fontWeight = FWeight.REGULAR,
                                    color = textColor
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .clip(primaryCornerFull.invoke())
                                    .width(150.dp)
                                    .height(100.dp)
                                    .background(gray),
                                contentAlignment = Alignment.Center,
                            ) {
                                AppText(
                                    value = it.toString(),
                                    textSize = TextSize.MEDIUM,
                                    fontWeight = FWeight.REGULAR,
                                    color = textColor
                                )
                            }
                        }
                    }
                }

            }
        }

    }

}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen {

    }
}