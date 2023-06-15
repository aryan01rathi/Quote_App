package com.example.quoteapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quoteapp.Models.quote
import com.example.textapp.screens.QuoteListItem

@Composable
fun quotelist(data:Array<quote>,onClick:(quot:quote)->Unit) {
    LazyColumn(modifier= Modifier.padding(10.dp),
        content = {
        items(data){
            QuoteListItem(quot=it,onClick)


        }
    })
}