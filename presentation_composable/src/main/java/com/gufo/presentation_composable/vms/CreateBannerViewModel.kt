package com.gufo.presentation_composable.vms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.gufo.presentation_composable.ImageModel
import com.gufo.presentation_composable.shapes.ShapesName
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreateBannerViewModel @Inject constructor(

): ViewModel() {
    var selectedImg by mutableStateOf<ImageModel?>(null)
        private set

    var selectedShape by mutableStateOf(ShapesName.NONE)
        private set

    val setSelectedImg = { model: ImageModel -> selectedImg = model}
    val selectShape = { shape: ShapesName -> selectedShape = shape }

}


