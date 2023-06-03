package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.screens.QuoteDetail
import com.example.quoteapp.screens.quotelistsceen
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlin.text.Typography.quote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataManager.loadassetfromFile(this)

        setContent{
            App()
        }



    }
}

@Composable
fun App() {
    if(DataManager.isdataloaded.value){
        quotelistsceen(data = DataManager.data) {
            
        }
    }
        
}
