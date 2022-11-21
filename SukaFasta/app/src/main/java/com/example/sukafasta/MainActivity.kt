package com.example.sukafasta

import android.os.Bundle
import android.util.Log
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
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this);
        setContent {
            SukaFastaTheme {
                Login(this)
            }
        }
    }
}

@Composable
fun Login(context: ComponentActivity) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginPage(navController = navController, context)
        }

        composable(Routes.Register.route){
            RegistrationPage(navController = navController, context)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPasswordPage(navController = navController, context)
        }
    }
}