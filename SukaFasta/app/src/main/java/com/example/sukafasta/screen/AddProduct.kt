package com.example.sukafasta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sukafasta.ui.theme.SukaFastaTheme


@Composable
fun MainScreen1() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Product", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                contentColor = Color.White,
                backgroundColor = Color(0XFF0F9D58),

                )
        },
        bottomBar = { BottomBar() }
    ) {
        addProduct()
//        addService()
    }

}

@Composable
fun BottomBar1() {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "")
        },
            label = { Text(text = "Home") },
            selected = (selectedItem.value == 0),
            onClick = {
                selectedItem.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange, "")
        },
            label = { Text(text = "My Appointment") },
            selected = (selectedItem.value == 1),
            onClick = {
                selectedItem.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Account") },
            selected = (selectedItem.value == 2),
            onClick = {
                selectedItem.value = 2
            })
    }
}



@Composable
fun addProduct() {
    var addProductName = remember {
        mutableStateOf("")
    }
    var addProductDesc = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .background(color = Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    ) { append("Select Product Category") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xfff35b5b),
                            fontSize = 14.sp
                        )
                    ) { append("*") }
                })
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    ) { append("Add Product Name") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xfff35b5b),
                            fontSize = 14.sp
                        )
                    ) { append("*") }
                }
            )

            OutlinedTextField(
                value = addProductName.value,
                onValueChange = { addProductName.value = it },
                label = { Text(text = "Add Product Name") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    ) { append("Add Product Description") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xfff35b5b),
                            fontSize = 14.sp
                        )
                    ) { append("*") }
                }
            )

            OutlinedTextField(
                value = addProductDesc.value,
                onValueChange = { addProductDesc.value = it },
                label = { Text(text = "Add Product Description") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Upload cover picture",
                color = Color.Black,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .width(width = 165.dp)
            )

            Box(
                modifier = Modifier
                    .width(width = 328.dp)
                    .height(height = 40.dp)
                    .background(color = Color.White)
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { /**/ }, modifier = Modifier
//                    .width(width = 228.dp)
                    .fillMaxWidth(1f)
                    .height(height = 43.dp)
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            ) {
                Text(
                    text = "Add New Product",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                )

            }


        }

    }
}






