package com.gufo.presentation_home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gufo.presentation_create.CreateBannerActivity
import com.gufo.presentation_home.ui.theme.GufoBannerTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GufoBannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen {
                        Toast.makeText(this, "Yeap", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, CreateBannerActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

