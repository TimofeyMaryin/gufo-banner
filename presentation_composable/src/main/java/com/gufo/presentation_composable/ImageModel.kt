package com.gufo.presentation_composable

import androidx.annotation.DrawableRes


data class ImageModel(
    val desc: String,
    @DrawableRes val img: Int,
)

val allImg = listOf(
    ImageModel(
        desc = "Первое",
        img = R.drawable.bg_1
    ),
    ImageModel(
        desc = "Второе",
        img = R.drawable.bg_2
    ),
)

val allImgSecond = listOf(
    ImageModel(
        desc = "Первое",
        img = R.drawable.second_img_1
    ),
    ImageModel(
        desc = "Второе",
        img = R.drawable.second_img_2
    ),
    ImageModel(
        desc = "Третье",
        img = R.drawable.second_img_3
    ),
    ImageModel(
        desc = "Четвортое",
        img = R.drawable.second_img_4
    ),
)