package com.example.sukafasta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.sukafasta.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sukafasta.ui.theme.primaryColor
import com.example.sukafasta.ui.theme.whiteBackground

@Composable
fun RegistrationPage(navController: NavController){
    val firstNameValue = remember { mutableStateOf("") }
    val lastNameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val salonNameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .clip(RoundedCornerShape(30.dp))
            .background(whiteBackground)
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
                Text(
                        text = "Create Account", fontSize = (30.sp),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = (2.sp)
                        ))

                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = firstNameValue.value,
                            onValueChange = { firstNameValue.value = it },
                            label = { Text(text = "First Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        OutlinedTextField(
                            value = lastNameValue.value,
                            onValueChange = { lastNameValue.value = it },
                            label = { Text(text = "Last Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = emailValue.value,
                            onValueChange = { emailValue.value = it },
                            label = { Text(text = "Email") },
                            placeholder = { Text(text = "e.g. example.email.com") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = phoneValue.value,
                            onValueChange = { phoneValue.value = it },
                            label = { Text(text = "Phone Number") },
                            placeholder = { Text(text = "e.g. 0712345678") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )

                        OutlinedTextField(
                            value = salonNameValue.value,
                            onValueChange = { salonNameValue.value = it },
                            label = { Text(text = "Salon Name") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = passwordValue.value,
                            onValueChange = { passwordValue.value = it },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }) {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = R.drawable.password_eye),
                                        contentDescription = "",
                                        tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        OutlinedTextField(
                            value = confirmPasswordValue.value,
                            onValueChange = { confirmPasswordValue.value = it },
                            label = { Text(text = "Confirm Password") },
                            placeholder = { Text(text = "Confirm Password") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            trailingIcon = {
                                IconButton(onClick = {
                                    confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                                }) {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(id = R.drawable.password_eye),
                                        contentDescription = "",
                                        tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(onClick = { }, modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)) {
                            Text(text = "Sign Up", fontSize = (20.sp))
                        }
                        Spacer(modifier = Modifier.padding(20.dp))
                        Text(
                            text = "Login Instead",
                            modifier = Modifier.clickable(onClick = {
                                navController.navigate("login_page"){
                                    popUpToId
                                    launchSingleTop = true
                                }
                            })
                        )
                        Spacer(modifier = Modifier.padding(20.dp))

                    }
        }
    }
}