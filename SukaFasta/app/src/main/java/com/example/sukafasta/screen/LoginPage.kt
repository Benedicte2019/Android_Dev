package com.example.sukafasta.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import com.example.sukafasta.R
import com.example.sukafasta.ui.theme.Purple700
import com.example.sukafasta.ui.theme.primaryColor
import com.example.sukafasta.ui.theme.whiteBackground

@Composable
fun LoginPage(navController: NavController){
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember {mutableStateOf("")}
    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember {FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
        )
    {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopCenter){
//            Text(text = stringResource(id = R.string.login_text))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .clip(RoundedCornerShape(30.dp, 30.dp))
                    .background(whiteBackground)
                    .padding(10.dp)
            ) {
                Text(text = stringResource(id = R.string.login_text),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold,
                        letterSpacing = (2.sp)),

                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(value = emailValue.value,
                        onValueChange = {emailValue.value = it},
                        label = { Text(text = "Email")},
                        placeholder = { Text(text = "e.g. example@domain.com")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(value = passwordValue.value, onValueChange = {passwordValue.value = it},
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value })
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
                    label = { Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                        
                    )
                    
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Login",
                            fontSize = TextUnit.Companion.Unspecified
                            )
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
//                    Text(
//                        text = "Create An Account",
//                        modifier = Modifier.clickable(onClick = {
//                            navController.navigate("Register"){
//                                popUpToId
//                                launchSingleTop = true
//                            }
//                        })
//                    )
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
                    Spacer(modifier = Modifier.padding(20.dp))
                    ClickableText(
                        text = AnnotatedString("Forgot Password?"),
                        onClick = {navController.navigate(Routes.ForgotPassword.route) },
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Default
                        )
                    )
                }
            }
        }
    }
}
