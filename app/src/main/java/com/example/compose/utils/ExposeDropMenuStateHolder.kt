package com.example.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import com.example.compose.R

class ExposeDropMenuStateHolder {

    var expanded by  mutableStateOf(false)
    var value by  mutableStateOf("")
    var selectedIndex by mutableStateOf(-1)
    var size by mutableStateOf(Size.Zero)
    val items = listOf("Test" ,"Test" ,"Test" ,"Test" ,"Test")
    val icon:Int
    @Composable get() = if (expanded){
          R.drawable.arrowup
    }else {
          R.drawable.arrowdwon
    }

    fun onEnabled (value_:Boolean){
        expanded = value_
    }
    fun onSelectedIndex (value_:Int){
        selectedIndex = value_
        value = items[selectedIndex]
    }
    fun onSize (value_:Size){
        size = value_
    }

}

@Composable
fun rememberExposeMenuStateHolder () = remember () {
    ExposeDropMenuStateHolder()
}