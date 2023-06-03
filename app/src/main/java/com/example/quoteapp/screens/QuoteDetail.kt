package com.example.quoteapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quoteapp.Models.quote
import com.example.quoteapp.R


@Composable
fun QuoteDetail(quot:quote){
    Box(
        contentAlignment = Alignment.Center,
        modifier= Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.White,
                        Color.LightGray
                    )
                )
            )

    ){
        Card (
            elevation = 4.dp,
            modifier= Modifier.padding(35.dp)
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                modifier= Modifier
                    .padding(10.dp)
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_format_quote_24),
                    contentDescription ="",
                    modifier= Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(
                    text =quot.text,
                    style= MaterialTheme.typography.h5,
                    modifier= Modifier.padding(start=4.dp)
                )
                Spacer(Modifier.padding(8.dp))
                Text(
                    text =quot.author,
                    style= MaterialTheme.typography.h6,
                    modifier = Modifier.padding(5.dp,2.dp,0.dp,4.dp)

                )
            }

        }
    }
}