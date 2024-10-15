package com.gufo.presentation_splash

import android.content.Intent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gufo.presentation_composable.AppText
import com.gufo.presentation_composable.FWeight
import com.gufo.presentation_composable.TextSize
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigate: () -> Unit,
) {

    var stateBgColor by remember { mutableStateOf(true) }
    val bgColor by animateColorAsState(
        targetValue = if (stateBgColor) Color.White else Color.Transparent,
        animationSpec = tween(800)
    )

    LaunchedEffect(key1 = Unit) {
        stateBgColor = !stateBgColor
        delay(3_000)
        stateBgColor = !stateBgColor
        delay(800)
        onNavigate()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon), contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(20.dp))
            
            AppText(
                value = "Добро пожаловать в Gufo среду",
                textSize = TextSize.EXTRA_LARGE,
                fontWeight = FWeight.BOLD,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(bgColor))

}