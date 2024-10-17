package com.gufo.presentation_composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gufo.presentation_composable.create_screen.SelectedImageCreateFragment
import com.gufo.presentation_composable.create_screen.SelectedShapesCreateFragment
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerScreenMainMenu(
    pagerState: PagerState,
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Container(weight = 1f) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                TopBarElement(value = "Гл. Фон", enable = pagerState.currentPage == 0) {
                    scope.launch { pagerState.animateScrollToPage(0) }
                }

                TopBarElement(value = "Форма", enable = pagerState.currentPage == 1) {
                    scope.launch { pagerState.animateScrollToPage(1) }
                }

                TopBarElement(value = "Вт. Фон", enable = pagerState.currentPage == 2) {
                    scope.launch { pagerState.animateScrollToPage(2) }
                }

                TopBarElement(value = "Текст", enable = pagerState.currentPage == 3) {
                    scope.launch { pagerState.animateScrollToPage(3) }
                }
            }
        }

        Container(weight = 8f) {
            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) {
                when (pagerState.currentPage) {
                    0 -> SelectedImageCreateFragment()
                    1 -> SelectedShapesCreateFragment()
                    2 -> Placer(color = Color.Red)
                    3 -> Placer(color = Color.DarkGray)
                }
            }
        }
    }
}


@Composable
fun Placer(color: Color) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color))
}

@Composable
private fun RowScope.TopBarElement(
    value: String,
    enable: Boolean,
    onClick: () -> Unit
) {
    val contentColor by animateColorAsState(targetValue = if (enable) selectedColor else Color.Transparent)
    Container(weight = 1f) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AppText(
                value = value,
                textSize = TextSize.SMALL,
                fontWeight = FWeight.REGULAR,
                color = textColor,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth(.9f)
                    .height(5.dp)
                    .background(contentColor),
            )


        }
    }
}