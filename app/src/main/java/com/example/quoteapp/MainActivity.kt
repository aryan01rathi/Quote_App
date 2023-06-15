package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class MainActivity : ComponentActivity() {
    private var isDarkTheme by mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       //' Datamanager is using IO thread
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
        onClick = { onThemeToggle(!isDarkTheme)
                 },

        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)



    ) {
     //Text(text = if (isDarkTheme) "Light Theme" else "Dark Theme")

        if(isDarkTheme) {
            Image(
                painter = painterResource(id = R.drawable.sundark),

                contentDescription = "",

                modifier = Modifier
                    .size(40.dp)

                    .rotate(180f)
            )
        }
        else{
            Image(

                painter = painterResource(id = R.drawable.sunlight),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)

                    .rotate(180f)
            )
        }
    }
}

enum class Pages{
    LIST,
    DETAIL
}

