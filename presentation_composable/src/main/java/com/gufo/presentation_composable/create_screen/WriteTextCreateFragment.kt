package com.gufo.presentation_composable.create_screen

import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.gufo.presentation_composable.AppText
import com.gufo.presentation_composable.FWeight
import com.gufo.presentation_composable.TextSize
import com.gufo.presentation_composable.primaryCornerFull
import com.gufo.presentation_composable.textColor
import com.gufo.presentation_composable.vms.CreateBannerViewModel

@Composable
fun WriteTextCreateFragment(
    viewModel: CreateBannerViewModel = hiltViewModel(),
) {


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            TextField(
                value = viewModel.textToBanner,
                onValueChange = viewModel.setTextToBanner,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = primaryCornerFull.invoke(),
                placeholder = {
                    AppText(
                        value = "Тема баннера",
                        textSize = TextSize.MEDIUM,
                        fontWeight = FWeight.REGULAR,
                        color = textColor.copy(.6f)
                    )
                },
                textStyle = MaterialTheme.typography.titleLarge
            )


        }
    }

}