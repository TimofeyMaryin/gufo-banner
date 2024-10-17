package com.gufo.presentation_composable.create_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.presentation_composable.AppText
import com.gufo.presentation_composable.FWeight
import com.gufo.presentation_composable.TextSize
import com.gufo.presentation_composable.bg
import com.gufo.presentation_composable.containerBg
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.selectedBush
import com.gufo.presentation_composable.selectedColor
import com.gufo.presentation_composable.shapes.BlobShapeView
import com.gufo.presentation_composable.shapes.ShapesName
import com.gufo.presentation_composable.shapes.WaveShapeView
import com.gufo.presentation_composable.vms.CreateBannerViewModel

@Composable
fun SelectedShapesCreateFragment(
    viewModel: CreateBannerViewModel = hiltViewModel()
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            ShapeItem(name = ShapesName.BLOB, status = viewModel.selectedShape == ShapesName.BLOB) {
                viewModel.selectShape(ShapesName.BLOB)
            }
        }

        item {
            ShapeItem(name = ShapesName.WAVE, status = viewModel.selectedShape == ShapesName.WAVE) {
                viewModel.selectShape(ShapesName.WAVE)
            }
        }





    }

}


@Composable
private fun ShapeItem(
    name: ShapesName,
    status: Boolean,
    onClick: () -> Unit,
) {
    val contentFadeState by animateFloatAsState(targetValue = if (status) 1f else 0.01f)

    val _selectedBush = Brush.horizontalGradient(
        listOf(
            Color(0xff009FFF).copy(contentFadeState),
            Color(0xffec2F4B).copy(contentFadeState)
        )
    )

    Box(modifier = Modifier.padding(vertical = 20.dp)) {
        Box(
            modifier = Modifier
                .clip(primaryCornerFull.invoke())
                .fillMaxWidth()
                .height(200.dp)
                .background(bg)
                .clickable { onClick() },
            contentAlignment = Alignment.Center,
        ) {

            // BlobShapeView(brush = selectedBush, modifier = Modifier.fillMaxSize())
            AppText(
                value = "HAHAHA",
                textSize = TextSize.LARGE,
                fontWeight = FWeight.BOLD,
                color = Color.Blue
            )
            // selected items

            // default items
            when (name) {
                ShapesName.BLOB -> {
                    BlobShapeView(color = Color.Black)
                }
                ShapesName.WAVE -> {
                    WaveShapeView(color = Color.Black)
                }
                ShapesName.NONE -> Spacer(modifier = Modifier.size(50.dp))
            }

            when (name) {
                ShapesName.BLOB -> {
                    BlobShapeView(brush = _selectedBush)
                }
                ShapesName.WAVE -> {
                    WaveShapeView(brush = _selectedBush)
                }
                ShapesName.NONE -> Spacer(modifier = Modifier.size(50.dp))
            }


        }
    }

}