package com.gufo.presentation_create

import android.graphics.Bitmap
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gufo.presentation_composable.Container
import com.gufo.presentation_composable.shapes.BlobShapeView

@Composable
fun CreateBannerScreen(
    onImageReady: (Bitmap) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Container(weight = 1f) {

            CreateAndSaveImage(onImageCreated = onImageReady) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    BlobShapeView(
                        color = Color.Red,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

        }

        Container(weight = 2f) {

        }

    }

}