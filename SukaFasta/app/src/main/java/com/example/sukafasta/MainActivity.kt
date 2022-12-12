package com.example.sukafasta

import NavBottomBar
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sukafasta.model.AppointmentViewModel
import com.example.sukafasta.model.UserViewModel
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
    val userViewModel: UserViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginPage(navController = navController, context, userViewModel.userList, onNavigateToHome = {phoneNumber -> navController.navigate(Routes.Home.route+"/$phoneNumber") })
        }

        composable(Routes.Register.route){
            RegistrationPage(navController = navController, context, {userViewModel.addUser(it)})
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPasswordPage(navController = navController, context)
        }

        composable(Routes.Home.route+"/{phoneNumber}", arguments = listOf(navArgument("phoneNumber"){type=
            NavType.StringType})){
            backStackEntry ->
            Home(navController, phoneNumber = backStackEntry.arguments?.getString("phoneNumber"), onNavigateToBookings = {phoneNumber, startDestination -> navController.navigate(Routes.NavBottomBar.route+"/$phoneNumber/$startDestination") })
        }

        composable(Routes.NavBottomBar.route+"/{phoneNumber}/{startDestination}",
            arguments = listOf(navArgument("phoneNumber"){type=NavType.StringType},
                                navArgument("startDestination"){type=NavType.StringType}))
        {
                backStackEntry ->
            NavBottomBar(viewModel, userViewModel, phoneNumber = backStackEntry.arguments?.getString("phoneNumber"),
                startDestination = backStackEntry.arguments?.getString("startDestination")
                )
        }

        // Appointment composable
        composable(Routes.Booking.route){
            Booking(viewModel)
        }

        // Account composable
        composable(Routes.Account.route){
            Account()
        }

        composable(Routes.AddService.route){
            AddService()
        }

        composable(Routes.Appointments.route){
            ClientAppointmentsScreen(viewModel.appointmentList, userViewModel.userList, {viewModel.deleteAppointment(it)})
        }

        // Blocking Time composable
        composable(Routes.BlockTime.route){
            BlockTime()
        }



    }
}