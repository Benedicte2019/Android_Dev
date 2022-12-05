package com.example.sukafasta.screen

import NavBottomBar
import android.os.Build
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sukafasta.R
import com.example.sukafasta.ui.theme.whiteBackground

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Home(navController: NavController){
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
            Row() {
                Image(
                    painterResource(R.drawable.ic_sukafasta_logo)
                    ,"sukafasta logo"
                )

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Hairdressing like never before.",
                        style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.Cursive,
                            letterSpacing = (2.sp)
                        ))
                    Text(text = "Book a slot from the comfort of your home and spend less time waiting for a service.")
                }
            }

            Spacer(modifier = Modifier.padding(60.dp))

            Button(
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    navController.navigate(Routes.NavBottomBar.route)
                    },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = "Book a Service",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    navController.navigate(Routes.Appointments.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .background(Color.White)
            ) {
                Text(
                    text = "View my Appointments",
                    fontSize = 20.sp
                )
            }
        }

    }
}