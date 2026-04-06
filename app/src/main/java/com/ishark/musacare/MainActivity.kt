package com.ishark.musacare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ishark.musacare.ui.MusaCareNavGraph
import com.ishark.musacare.ui.theme.MusaCareTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusaCareTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MusaCareNavGraph()
                }
            }
        }
    }
}