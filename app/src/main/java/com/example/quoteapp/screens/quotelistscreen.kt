package com.example.quoteapp.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.DataManager.data
import com.example.quoteapp.Models.quote



@Composable
fun quotelistsceen(data: Array<quote>,onClick:(quote:quote)->Unit) {
    Column(
        modifier=Modifier.padding(12.dp)
    ){
        Text(
            text="Quotes App",
            textAlign = TextAlign.Center,
            modifier= Modifier
                .padding(top = 8.dp, bottom = 9.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.h5,
            color = Color.White
        )

        

        quotelist(data = data,onClick)

    }
}