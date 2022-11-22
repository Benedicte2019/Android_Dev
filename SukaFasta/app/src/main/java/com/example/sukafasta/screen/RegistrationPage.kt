package com.example.sukafasta.screen

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.sukafasta.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.sukafasta.ui.theme.Purple700
import com.example.sukafasta.ui.theme.primaryColor
import com.example.sukafasta.ui.theme.whiteBackground
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.exp

@Composable
fun RegistrationPage(navController: NavController, context: ComponentActivity){

    val auth = Firebase.auth
    val firstNameValue = remember { mutableStateOf("") }
    val lastNameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val salonNameValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    var expandedIsHairdresserDropDown by remember { mutableStateOf(false) }
    val dropDownList = listOf("Client", "Hairdresser")
    var selectedDropDownItem by remember { mutableStateOf("") }
    var dropDownTextFieldSize by remember { mutableStateOf(Size.Zero) }
    val dropDownArrowIcon = if (expandedIsHairdresserDropDown){
                                Icons.Filled.KeyboardArrowUp
                            }else{
                                Icons.Filled.ArrowDropDown
                            }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
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

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = selectedDropDownItem,
                            onValueChange = { selectedDropDownItem = it },
                            label = { Text(text = "Hairdresser or Client") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .onGloballyPositioned { coordinates ->
                                    dropDownTextFieldSize = coordinates.size.toSize()
                                },
                            trailingIcon = {
                                Icon(dropDownArrowIcon, contentDescription = "",
                                    Modifier.clickable {
                                        expandedIsHairdresserDropDown =
                                            !expandedIsHairdresserDropDown
                                    })
                            }
                        )
                    }
                    DropdownMenu(expanded = expandedIsHairdresserDropDown,
                                onDismissRequest = { expandedIsHairdresserDropDown = false},
                                modifier = Modifier
                                    .width(with(LocalDensity.current){ dropDownTextFieldSize.width.toDp() })
                        ) {
                        dropDownList.forEach({ item ->
                            DropdownMenuItem(onClick = {
                                selectedDropDownItem = item
                                expandedIsHairdresserDropDown = false
                            }) {
                                    Text(text = item)
                            }
                        })
                    }

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

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        shape = RoundedCornerShape(30.dp),
                        onClick = {
                               auth.createUserWithEmailAndPassword(
                                   emailValue.value,
                                   passwordValue.value
                               )
                                   .addOnCompleteListener(context){task ->
                                       if (task.isSuccessful) {
                                           Log.d("AUTH", "Success!")
                                           Toast
                                               .makeText(
                                                   context,
                                                   context.resources.getString(R.string.register_success),
                                                   Toast.LENGTH_LONG
                                               ).show()
                                       }
                                       else {
                                           Log.d("AUTH", "Failed!")
                                           Toast
                                               .makeText(
                                                   context,
                                                   context.resources.getString(R.string.register_failed),
                                                   Toast.LENGTH_LONG
                                               ).show()
                                       }
                                   }
                    },
                        modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)) {
                        Text(text = "Sign Up", fontSize = (20.sp))
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = AnnotatedString("Login Instead"),
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate(Routes.Login.route){
                                popUpToId
                                launchSingleTop = true
                            }
                        }),
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            color = Purple700
                        )
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }
        }
    }
}