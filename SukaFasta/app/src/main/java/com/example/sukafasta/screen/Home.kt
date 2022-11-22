package com.example.sukafasta.screen

import NavBottomBar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Home(){
    Column(Modifier.padding(20.dp)) {
        Text(text = "Nothing Here Yet!")
    }
}