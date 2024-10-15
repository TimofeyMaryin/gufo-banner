package com.gufo.presentation_splash

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
import com.gufo.presentation_splash.ui.theme.GufoBannerTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GufoBannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val i = Intent(this, com.gufo.presentation_home.HomeActivity::class.java)

                    SplashScreen {
                        // Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
                        startActivity(i)
                    }
                }
            }
        }
    }
}

