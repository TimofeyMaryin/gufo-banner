package com.gufo.presentation_create

import android.graphics.Bitmap
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.imageResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.presentation_composable.Container
import com.gufo.presentation_composable.BannerScreenMainMenu
import com.gufo.presentation_composable.containerBg
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.primaryCornerTop
import com.gufo.presentation_composable.shapes.BlobShapeView
import com.gufo.presentation_composable.vms.CreateBannerViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreateBannerScreen(
    viewModel: CreateBannerViewModel = hiltViewModel(),
    onImageReady: (Bitmap) -> Unit
) {
    val pagerState = rememberPagerState { 5 }

    val imageBitmap = viewModel.selectedImg?.img?.let { ImageBitmap.imageResource(id = it) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Container(weight = 1f) {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .clip(primaryCornerFull.invoke())
                        .fillMaxSize(.9f)
                        .background(Color.Blue)
                ) {
                    if (imageBitmap != null) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawIntoCanvas { canvas ->
                                val paint = Paint()
                                canvas.drawImage(
                                    imageBitmap,
                                    topLeftOffset = Offset.Zero,
                                    paint = paint
                                )
                            }
                        }
                    }
                    BlobShapeView(
                        color = Color.Red,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }

        }

        Container(weight = 2f) {

            Box(
                modifier = Modifier
                    .clip(primaryCornerTop.invoke())
                    .fillMaxSize()
                    .background(containerBg),
                contentAlignment = Alignment.Center
            ) {
                BannerScreenMainMenu(pagerState = pagerState)


            }


        }

    }

}
