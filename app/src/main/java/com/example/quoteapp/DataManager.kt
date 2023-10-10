package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.Models.quote
import com.google.gson.Gson
import java.nio.charset.Charset


object DataManager {

    var data= emptyArray<quote>()
    //mutable state are  independent of thread

    var currentPage= mutableStateOf(Pages.LIST)
    val isdataloaded= mutableStateOf(false)
    //this can either hold a quote or null value
    var currentQuote: quote? =null

    fun loadassetfromFile(context: Context) {
        val inputStream = context.assets.open("quote.JSON")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<quote>::class.java)
        isdataloaded.value = true
    }

    fun switchPages(quot: quote?=null){
        if(currentPage.value== Pages.LIST){
            currentQuote=quot
            currentPage.value=Pages.DETAIL
        }
        else{
            currentPage.value=Pages.LIST
        }
    }
}