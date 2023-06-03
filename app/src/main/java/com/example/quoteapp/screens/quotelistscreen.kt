package com.example.quoteapp.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.Models.quote

@Composable
fun quotelistsceen(data: Array<quote>, onClick:()->Unit) {
    Column(
        modifier=Modifier.padding(15.dp)
    ){
        Text(
            text = "Quotes App",
            fontSize = 30.sp,

            style = MaterialTheme.typography.h5,
            modifier= Modifier.padding(8.dp,24.dp)
        )
        quotelist(data = data) {
            onClick()
        }

    }
}