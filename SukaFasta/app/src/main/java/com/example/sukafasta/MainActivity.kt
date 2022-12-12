package com.example.sukafasta

import NavBottomBar
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sukafasta.model.AppointmentViewModel
import com.example.sukafasta.screen.*
import com.example.sukafasta.ui.theme.SukaFastaTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Login(context: ComponentActivity) {
    val navController = rememberNavController()
    val viewModel: AppointmentViewModel = viewModel();
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

        composable(Routes.Home.route){
            Home(navController)
        }

        // Appointment composable
        composable(Routes.Booking.route){
            Booking(viewModel)
        }

        // Account composable
        composable(Routes.Account.route){
            Account()
        }

        composable(Routes.NavBottomBar.route){
            NavBottomBar(viewModel)
        }

        composable(Routes.AddService.route){
            AddService()
        }

        composable(Routes.Appointments.route){
            ClientAppointmentsScreen(viewModel)
        }



    }
}