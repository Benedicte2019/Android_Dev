package com.example.sukafasta.screen

import NavBottomBar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Home(){
    Column {
        Text(text = "Nothing Here Yet!")
//        NavBottomBar()
    }
}