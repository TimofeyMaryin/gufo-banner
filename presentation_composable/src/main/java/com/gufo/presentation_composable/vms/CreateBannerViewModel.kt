package com.gufo.presentation_composable.vms

import android.media.Image
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
    var selectedSecondImg by mutableStateOf<ImageModel?>(null)
        private set
    var textToBanner by mutableStateOf("")
        private set

    var selectedShape by mutableStateOf(ShapesName.NONE)
        private set

    val setSelectedImg = { model: ImageModel -> selectedImg = model}
    val setSelectedSecondImage = { model: ImageModel -> selectedSecondImg = model }
    val selectShape = { shape: ShapesName -> selectedShape = shape }
    val setTextToBanner = { value: String -> textToBanner = value }

}


