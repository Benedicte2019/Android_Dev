package com.example.sukafasta.screen

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import com.example.sukafasta.R
import com.example.sukafasta.model.User
import com.example.sukafasta.ui.theme.Purple700
import com.example.sukafasta.ui.theme.primaryColor
import com.example.sukafasta.ui.theme.whiteBackground
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun LoginPage(navController: NavController, context: ComponentActivity, userList: List<User>, onNavigateToHome: (phoneNumber: String) -> Unit) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val phoneNumberValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .clip(RoundedCornerShape(30.dp, 30.dp))
                .background(whiteBackground)
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login_text),
                style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    letterSpacing = (2.sp)
                ),

                )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = phoneNumberValue.value,
                    onValueChange = { phoneNumberValue.value = it },
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "e.g. 07810000000") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = passwordValue.value, onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        })
                        {
                            androidx.compose.material.Icon(
                                imageVector = ImageVector.vectorResource(
                                    id = R.drawable.password_eye,
                                ),
                                contentDescription = "",
                                tint = if (passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .focusRequester(focusRequester = focusRequester),

                    )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    shape = RoundedCornerShape(30.dp),
                    onClick = {
                        if (!phoneNumberValue.value.equals("") && !passwordValue.value.equals("")) {
                            for (user in userList) {
                                if (user.phoneNumber.equals(phoneNumberValue.value, false)
                                ) {
                                    if (user.password.equals(passwordValue.value, false))
                                    {
                                        Toast
                                            .makeText(
                                                context,
                                                context.resources.getString(R.string.login_successful),
                                                Toast.LENGTH_LONG
                                            ).show()
//                                        navController.navigate(Routes.Home.route)
                                        onNavigateToHome(phoneNumberValue.value)
                                    }  else {
                                        Toast
                                            .makeText(
                                                context,
                                                context.resources.getString(R.string.login_failed),
                                                Toast.LENGTH_LONG
                                            ).show()
                                    }
                                }
                            }
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    context.resources.getString(R.string.empty_email_password),
                                    Toast.LENGTH_LONG
                                ).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 4.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp,
                        hoveredElevation = 15.dp,
                        focusedElevation = 10.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                        .border(1.dp, MaterialTheme.colors.secondary, RoundedCornerShape(30.dp))
                ) {
                    Text(
                        text = "Login",
                        fontSize = 20.sp
                    )
                }
                Row() {
                    ClickableText(
                        text = AnnotatedString("Create an Account"),
                        modifier = Modifier
                            .padding(20.dp),
                        onClick = { navController.navigate(Routes.Register.route) },
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            textDecoration = TextDecoration.Underline,
                            color = Purple700
                        )
                    )
                    ClickableText(
                        text = AnnotatedString("Forgot Password?"),
                        modifier = Modifier
                            .padding(20.dp),
                        onClick = { navController.navigate(Routes.ForgotPassword.route) },
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default,
                            textDecoration = TextDecoration.Underline,
                            color = Color.Red
                        )
                    )
                }
            }
        }
    }
}


