package com.example.quoteapp

//import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quoteapp.screens.QuoteDetail
import com.example.quoteapp.screens.quotelistsceen
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    private var isDarkTheme by mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // Datamanager is using IO thread
        CoroutineScope(Dispatchers.IO).launch{
           // delay(1000)
            DataManager.loadassetfromFile(applicationContext)
        }

        setContent{
            QuoteAppTheme(darkTheme = isDarkTheme) {
                App(isDarkTheme) { isDark -> isDarkTheme = isDark }
            }

        }



    }
}

@Composable

fun App(isDarkTheme: Boolean, onThemeToggle: (Boolean) -> Unit) {


    if(DataManager.isdataloaded.value){
        if(DataManager.currentPage.value==Pages.LIST)
        quotelistsceen(data = DataManager.data){
            DataManager.switchPages(it)
        }
        else{
            DataManager.currentQuote?.let { QuoteDetail(quot = it,isDarkTheme) }

        }
    }
    else{
        Box(
            contentAlignment= Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ){
            Text(
                text = "Loading......",
                style = MaterialTheme.typography.h3
            )
        }
    }

    Button(
        onClick = { onThemeToggle(!isDarkTheme) },


       // shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        modifier = Modifier
            .padding(20.dp, 10.dp, 0.dp, 0.dp)
            .clip(CircleShape)
            .height(55.dp)
            .width(55.dp)

    ) {
        if(isDarkTheme) {
            Image(
                painter = painterResource(id = R.drawable.sunlight),

                contentDescription = "",

                modifier = Modifier
                    .size(600.dp)


            )
        }
        else{
            Image(

                painter = painterResource(id = R.drawable.moon),
                contentDescription = "",
                modifier = Modifier
                    .size(400.dp)


            )
        }
    }
}

enum class Pages{
    LIST,
    DETAIL
}

