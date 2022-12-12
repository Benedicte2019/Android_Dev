import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sukafasta.screen.*
import com.example.sukafasta.R
import com.example.sukafasta.model.*
import com.example.sukafasta.ui.theme.primaryColor

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavBottomBar(viewModel: AppointmentViewModel, userViewModel: UserViewModel, serviceViewModel: ServiceViewModel,
                 productViewModel: ProductViewModel, phoneNumber: String? = "", startDestination: String?) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.bookAppointment))
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                contentColor = Color.White,
                backgroundColor = primaryColor,

                )
        },
        content = { NavigationHandler(navController = navController, viewModel, userViewModel, serviceViewModel, productViewModel, phoneNumber, startDestination)},
        bottomBar = { NewBottomBar(navController = navController, userViewModel.userList, phoneNumber) }
    )
}

// function to handle navigation
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavigationHandler(
    navController: NavHostController, viewModel: AppointmentViewModel, userViewModel: UserViewModel, serviceViewModel: ServiceViewModel, productViewModel: ProductViewModel, phoneNumber: String?, startDestination: String?
){
    if (startDestination != null) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ){
            // Home composable
//        composable(Routes.Home.route){
//            Home()
//        }

            // Appointment composable
            composable(Routes.Booking.route){
                Booking(viewModel, serviceViewModel, phoneNumber)
            }

//        // Account composable
//        composable(Routes.Account.route){
//            Account()
//        }

            composable(Routes.AddService.route){
                AddService({serviceViewModel.addService(it)})
            }

            composable(Routes.AddProduct.route){
                AddProduct(productViewModel.productList, {productViewModel.addProduct(it)}, {productViewModel.deleteProduct(it)}, phoneNumber)
            }

            composable(Routes.Appointments.route){
                ClientAppointmentsScreen(viewModel.appointmentList, userViewModel.userList, {viewModel.deleteAppointment(it)}, phoneNumber)
            }
        }
    }
}

// new BottomBar for testing new implementation
@Composable
fun NewBottomBar(navController: NavHostController, userList: List<User>, phoneNumber: String?){
    val role = "client"
    val bottomNavElements = mutableListOf<BottomBarItem>()
    for (user in userList)
    {
        if (user.phoneNumber.equals(phoneNumber))
        {
            if (user.role.equals("client", true))
            {
                for (navItem in BottomNavItems.BottomItems)
                {
                    if (navItem.visibleTo.equals("client", true) || navItem.visibleTo.equals("all", true))
                        bottomNavElements.add(navItem)
                }
            }
            else
                for (navItem in BottomNavItems.BottomItems)
                {
                    if (navItem.visibleTo.equals("hairdresser", true) || navItem.visibleTo.equals("all", true))
                        bottomNavElements.add(navItem)
                }
        }
    }
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        // handling state for each item selected on bottom bar
        bottomNavElements.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                },
            )
        }

    }
}