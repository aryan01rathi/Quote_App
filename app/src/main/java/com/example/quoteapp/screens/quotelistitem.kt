package com.example.textapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.rotationMatrix
import com.example.quoteapp.Models.quote
import com.example.quoteapp.R


@Composable
fun QuoteListItem(quot:quote, onClick:(quot:quote)->Unit) {
    Card(
        elevation = 8.dp,
        modifier= Modifier
            .clickable { onClick(quot) }
            .padding(4.dp)
    ){
        Row(
            modifier=Modifier.padding(10.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_format_quote_24),
                contentDescription = " ",
                colorFilter=ColorFilter.tint(Color.White),
                alignment= Alignment.TopStart,
                modifier= Modifier
                    .padding(2.dp,0.dp,6.dp,0.dp)
                    .size(35.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(modifier=Modifier.padding(5.dp))
            Column(
                modifier=Modifier.weight(1f)
            ){
                Text(
                    text = quot.text,
                    style = MaterialTheme.typography.body2,
                    //fontweight=FontWeight.Medium,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,5.dp)
                )
                Spacer(modifier=Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth(.5f)
                        .height(1.dp)
                )
                Spacer(modifier=Modifier.padding(2.dp))
                Text(
                    text = quot.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight=FontWeight.Thin,
                    modifier=Modifier.padding(top=4.dp)

                )
            }
        }
        
    }
}

