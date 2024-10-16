package com.gufo.presentation_create

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gufo.presentation_composable.vms.CreateBannerViewModel
import com.gufo.presentation_create.ui.theme.GufoBannerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateBannerActivity : ComponentActivity() {
    val viewModel: CreateBannerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GufoBannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateBannerScreen {

                    }
                }
            }
        }
    }
}

