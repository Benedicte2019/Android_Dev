package com.example.sukafasta.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sukafasta.R
import com.example.sukafasta.ui.theme.Purple700
import com.example.sukafasta.ui.theme.primaryColor
import com.example.sukafasta.ui.theme.whiteBackground

@Composable
fun ForgotPasswordPage(navController: NavController, context: ComponentActivity) {
    Box(modifier = Modifier.fillMaxSize()) {
        Fields(navController)
    }
}

@Composable
fun Fields(navController: NavController) {
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
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
                    text = stringResource(id = R.string.reset_password_text),
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold,
                        letterSpacing = (2.sp)),

                    )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "e.g. example@domain.com") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it },
                        label = { Text(text = "Phone") },
                        placeholder = { Text(text = "e.g. 0781234567") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )


                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Reset Password",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
}