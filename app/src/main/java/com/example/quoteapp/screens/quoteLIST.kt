package com.example.quoteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteapp.Models.quote
import com.example.textapp.screens.QuoteListItem

@Composable
fun quotelist(data:Array<quote>,onClick:()->Unit) {
    LazyColumn(content = {
        items(data){
            QuoteListItem(quot=it){
                onClick()
            }
        }
    })
}