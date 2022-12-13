package com.example.sukafasta.screen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sukafasta.R
import com.example.sukafasta.model.Service
import com.example.sukafasta.ui.theme.SukaFastaTheme

@Composable
fun AddService(addService: (Service) -> Unit) {
    val context = LocalContext.current
    var addServiceName = remember {
        mutableStateOf("")
    }
    var addServiceDesc = remember {
        mutableStateOf("")
    }
    var addPrice = remember {
        mutableStateOf("")
    }
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
        Toast
            .makeText(
                context,
                addServiceName.value + " " + context.resources.getString(R.string.image_uploaded),
                Toast.LENGTH_LONG
            ).show()
    }
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight(1f)
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
                },
                modifier = Modifier
                    .padding(10.dp)
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
                },
            modifier = Modifier
                .padding(10.dp)
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
            OutlinedTextField(
                value = addPrice.value,
                onValueChange = { addPrice.value = it },
                label = { Text(text = "Add Price") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 12.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)

            )

            Spacer(modifier = Modifier.padding(10.dp))



            Button(
//                shape = RoundedCornerShape(10.dp),
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
//                    .width(width = 228.dp)
                    .fillMaxWidth(1f)
                    .padding(top = 22.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .height(height = 43.dp)


            ) {
                Text(
                    text = "Upload cover picture",
//                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 14.sp),
//                    modifier = Modifier
//                        .width(width = 165.dp)
//                        .padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                shape = RoundedCornerShape(30.dp),
                onClick = {
                          if (!addServiceDesc.value.equals("") && !addServiceName.value.equals(""))
                          {
                              addService(Service(addServiceName.value, addServiceDesc.value, addPrice.value, null))
                              Toast
                                  .makeText(
                                      context,
                                      addServiceName.value + " " + context.resources.getString(R.string.service_added),
                                      Toast.LENGTH_LONG
                                  ).show()
                          }
                },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 22.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
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
