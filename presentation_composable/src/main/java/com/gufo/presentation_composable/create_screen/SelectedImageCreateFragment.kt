package com.gufo.presentation_composable.create_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.custom.gufoshadow.shadow
import com.gufo.presentation_composable.AppText
import com.gufo.presentation_composable.FWeight
import com.gufo.presentation_composable.ImageModel
import com.gufo.presentation_composable.TextSize
import com.gufo.presentation_composable.allImg
import com.gufo.presentation_composable.bg
import com.gufo.presentation_composable.primaryCorner
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.selectedColor
import com.gufo.presentation_composable.textColor
import com.gufo.presentation_composable.vms.CreateBannerViewModel

@Composable
fun SelectedImageCreateFragment(
    viewModel: CreateBannerViewModel = hiltViewModel()
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(allImg) {
            ImageItem(model = it, selected = viewModel.selectedImg == it) {
                viewModel.setSelectedImg(it)
            }
        }
    }

}

@Composable
private fun ImageItem(
    model: ImageModel,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val containerBg by animateColorAsState(targetValue = if (selected) selectedColor.copy(.4f) else selectedColor.copy(.001f))
    Box(Modifier.padding(vertical = 20.dp)) {

        Box(
            modifier = Modifier
                .clip(primaryCornerFull.invoke())
                .fillMaxWidth(.9f)
                .height(250.dp)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = model.img), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

            Box(modifier = Modifier.fillMaxSize(.9f), contentAlignment = Alignment.BottomStart) {
                Box(
                    modifier = Modifier
                        .shadow(bg, borderRadius = primaryCorner)
                        .clip(primaryCornerFull.invoke()),
                    contentAlignment = Alignment.Center
                ) {
                    AppText(
                        value = model.desc,
                        textSize = TextSize.SMALL,
                        fontWeight = FWeight.TINY,
                        color = textColor
                    )
                }
            }

            Box(modifier = Modifier
                .fillMaxSize()
                .background(containerBg))
        }
    }

}