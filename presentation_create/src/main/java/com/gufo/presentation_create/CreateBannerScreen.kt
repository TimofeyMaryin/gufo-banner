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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.imageResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.presentation_composable.Container
import com.gufo.presentation_composable.BannerScreenMainMenu
import com.gufo.presentation_composable.containerBg
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.primaryCornerTop
import com.gufo.presentation_composable.selectedBush
import com.gufo.presentation_composable.shapes.BlobShapeView
import com.gufo.presentation_composable.shapes.ShapesName
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
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        val empty = Path().apply {
                            close()
                        }
                        val blob = Path().apply {
                            moveTo(width * 0.1f, height * 0.4f)
                            // Создаем волны по верхней части
                            cubicTo(
                                width * 0.3f, height * 0.2f,
                                width * 0.5f, height * 0.5f,
                                width * 0.7f, height * 0.4f
                            )
                            cubicTo(
                                width * 0.9f, height * 0.2f,
                                width * 1.1f, height * 0.6f,
                                width * 0.9f, height * 0.8f
                            )
                            // Плавный переход вниз
                            cubicTo(
                                width * 0.7f, height * 1.0f,
                                width * 0.3f, height * 1.0f,
                                width * 0.1f, height * 0.8f
                            )
                            // Создаем волны по нижней части
                            cubicTo(
                                width * -0.1f, height * 0.6f,
                                width * 0.0f, height * 0.5f,
                                width * 0.1f, height * 0.4f
                            )
                            close()
                        }
                        val wave = Path().apply {
                            moveTo(width * 0.1f, height * 0.2f)

                            // Верхняя волна
                            cubicTo(
                                width * 0.3f, height * 0.05f,
                                width * 0.5f, height * 0.3f,
                                width * 0.7f, height * 0.2f
                            )
                            cubicTo(
                                width * 0.9f, height * 0.1f,
                                width * 1.1f, height * 0.3f,
                                width * 0.9f, height * 0.5f
                            )

                            // Правая сторона с волной
                            cubicTo(
                                width * 0.95f, height * 0.7f,
                                width * 0.85f, height * 0.9f,
                                width * 0.7f, height * 0.8f
                            )

                            // Нижняя волна
                            cubicTo(
                                width * 0.5f, height * 1.05f,
                                width * 0.3f, height * 0.7f,
                                width * 0.1f, height * 0.8f
                            )

                            // Левая сторона с волной
                            cubicTo(
                                width * 0.0f, height * 0.6f,
                                width * -0.05f, height * 0.4f,
                                width * 0.1f, height * 0.2f
                            )
                            close()
                        }

                        if (imageBitmap != null) {
                            drawIntoCanvas { canvas ->
                                val paint = Paint()
                                canvas.drawImage(
                                    imageBitmap,
                                    topLeftOffset = Offset.Zero,
                                    paint = paint
                                )
                            }
                        }

                        drawPath(
                            path = when (viewModel.selectedShape) {
                                ShapesName.BLOB -> blob
                                ShapesName.WAVE -> wave
                                ShapesName.NONE -> empty
                            },
                            brush = selectedBush

                        )

                    }

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
