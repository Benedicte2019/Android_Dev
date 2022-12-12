package com.example.sukafasta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
<<<<<<< Updated upstream
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
=======
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
>>>>>>> Stashed changes
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sukafasta.ui.theme.SukaFastaTheme

@Composable
<<<<<<< Updated upstream
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Service", color = Color.White)
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
        addService()
//        addProduct()
    }

}

@Composable
fun BottomBar() {
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
fun addService() {
    var addServiceName = remember {
        mutableStateOf("")
    }
    var addServiceDesc = remember {
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
                    ) { append("Add Service Name") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xfff35b5b),
                            fontSize = 14.sp
                        )
                    ) { append("*") }
                }
            )

            OutlinedTextField(
                value = addServiceName.value,
                onValueChange = { addServiceName.value = it },
                label = { Text(text = "Add Service Name") },
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
                    ) { append("Add Service Description") }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xfff35b5b),
                            fontSize = 14.sp
                        )
                    ) { append("*") }
                }
            )

            OutlinedTextField(
                value = addServiceDesc.value,
                onValueChange = { addServiceDesc.value = it },
                label = { Text(text = "Add Service Description") },
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
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .height(height = 43.dp)
            ) {
                Text(
                    text = "Add New Service",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                )

            }
            Spacer(modifier = Modifier.padding(10.dp))


        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SukaFastaTheme {
        MainScreen()
    }
}
=======
fun AddService(function: () -> Unit) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(height = 65.dp)
                .padding(top = 575.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(height = 65.dp)
                    .background(color = Color.White))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(width = 303.dp)
                    .height(height = 43.dp)
                    .padding(
                        start = 28.dp,
                        top = 584.dp
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .width(width = 40.dp)
                        .height(height = 43.dp)
                        .padding(top = 584.dp)
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.material-symbols:home-rounded),
//                        contentDescription = "material-symbols:home-rounded",
//                        colorFilter = ColorFilter.tint(Color(0xff514545)),
//                        modifier = Modifier
//                            .size(size = 28.dp))
                    Text(
                        text = "Home",
                        color = Color(0xff514545),
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(width = 70.dp))
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(width = 78.dp)
                        .height(height = 41.dp)
                        .padding(top = 586.dp)
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.bi:calendar-check),
//                        contentDescription = "bi:calendar-check",
//                        colorFilter = ColorFilter.tint(Color(0xff514545)),
//                        modifier = Modifier
//                            .size(size = 24.dp))
                    Text(
                        text = "My Booking",
                        color = Color(0xff514545),
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(width = 60.dp))
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(width = 55.dp)
                        .height(height = 43.dp)
                        .padding(top = 584.dp)
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.mdi-light:account),
//                        contentDescription = "mdi-light:account",
//                        colorFilter = ColorFilter.tint(Color(0xff18978f)),
//                        modifier = Modifier
//                            .size(size = 28.dp))
                    Text(
                        text = "Account",
                        color = Color(0xff18978f),
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
        Surface(
            shape = RoundedCornerShape(2f),
            modifier = Modifier
                .width(width = 328.dp)
                .height(height = 32.dp)
                .padding(
                    start = 12.dp,
                    top = 19.dp
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.End
            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.material-symbols:arrow-back-rounded),
//                    contentDescription = "material-symbols:arrow-back-rounded",
//                    colorFilter = ColorFilter.tint(Color(0xff152c47)),
//                    modifier = Modifier
//                        .width(width = 30.dp)
//                        .height(height = 24.dp))
                Spacer(
                    modifier = Modifier
                        .width(width = 13.dp))
                Text(
                    text = "Add Service",
                    color = Color.Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .width(width = 285.dp)
                        .height(height = 32.dp))
            }
        }
        Box(
            modifier = Modifier
                .width(width = 328.dp)
                .height(height = 50.dp)
                .background(color = Color.White))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Black,
                    fontSize = 14.sp)
                ) {append("Add Service name")}
                withStyle(style = SpanStyle(
                    color = Color(0xfff35b5b),
                    fontSize = 14.sp)) {append("*")}})
        Box(
            modifier = Modifier
                .width(width = 328.dp)
                .height(height = 70.dp)
                .background(color = Color.White))
        Box(
            modifier = Modifier
                .width(width = 328.dp)
                .height(height = 70.dp)
                .background(color = Color.White))
        Text(
            text = "Add Service description",
            color = Color.Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp
            )
        )
        Text(
            text = "Upload cover picture",
            color = Color.Black,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp
            ),
            modifier = Modifier
                .width(width = 165.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .width(width = 328.dp)
                .height(height = 45.dp)
                .padding(
                    start = 17.dp,
                    top = 494.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .width(width = 328.dp)
                    .height(height = 45.dp)
                    .background(color = Color(0xff18978f)))
            Text(
                text = "Add New Service",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .width(width = 328.dp)
                    .height(height = 43.dp))

        }
//        Image(
//            painter = painterResource(id = R.drawable.ic:baseline-image-search),
//            contentDescription = "ic:baseline-image-search",
//            colorFilter = ColorFilter.tint(Color(0xffd9d9d9)),
//            modifier = Modifier
//                .size(size = 50.dp))

}
>>>>>>> Stashed changes
