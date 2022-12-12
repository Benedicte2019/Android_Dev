package com.example.sukafasta.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

//class AddService2 {
//}

@Composable
fun AddNewService(){
    var addServiceName = remember {
        mutableStateOf("")
    }
    var addServiceDesc = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .padding(20.dp)){
//        Image(
//            painter = painterResource(id = R.drawable.dog),
//            contentDescription = stringResource(id = R.string.dog_content_description)
//        )
    }
}