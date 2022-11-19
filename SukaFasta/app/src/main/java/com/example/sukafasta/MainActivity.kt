package com.example.sukafasta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sukafasta.screen.ForgotPasswordPage
import com.example.sukafasta.screen.LoginPage
import com.example.sukafasta.screen.RegistrationPage
import com.example.sukafasta.screen.Routes
import com.example.sukafasta.ui.theme.SukaFastaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SukaFastaTheme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.Register.route){
            RegistrationPage(navController = navController)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPasswordPage(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SukaFastaTheme {
        Login()
    }
}