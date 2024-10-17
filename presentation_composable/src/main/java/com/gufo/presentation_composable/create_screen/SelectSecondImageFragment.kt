package com.gufo.presentation_composable.create_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.presentation_composable.allImgSecond
import com.gufo.presentation_composable.vms.CreateBannerViewModel

@Composable
fun SelectedSecondImageFragment(
    viewModel: CreateBannerViewModel = hiltViewModel(),
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        this.items(allImgSecond) {
            ImageItem(model = it, selected = viewModel.selectedSecondImg == it) {
                viewModel.setSelectedSecondImage(it)
            }
        }
    }

}