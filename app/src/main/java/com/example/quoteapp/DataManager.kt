package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.Models.quote
import com.google.gson.Gson
import java.nio.charset.Charset


object DataManager {

    var data= emptyArray<quote>()
    val isdataloaded= mutableStateOf(false)

    fun loadassetfromFile(context: Context){
        //val inputStream=context.assets.open("quote.json")
        val inputStream=context.assets.open("quote.JSON")
        val size:Int= inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, Charsets.UTF_8)
        val gson= Gson()
        data=gson.fromJson(json,Array<quote>::class.java)
        isdataloaded.value=true
    }
}