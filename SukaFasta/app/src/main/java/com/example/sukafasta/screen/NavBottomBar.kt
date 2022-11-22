import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sukafasta.screen.*
import com.example.sukafasta.R
import com.example.sukafasta.ui.theme.primaryColor

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavBottomBar() {
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
        content = { NavigationHandler(navController = navController)},
        bottomBar = { NewBottomBar(navController = navController) }
    )
}


//@Composable
//fun TopBar()
//{
//
//}


// function to handle navigation
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavigationHandler(
    navController: NavHostController,
//    startDestination: String = "home"
){
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ){
        // Home composable
        composable(Routes.Home.route){
            Home()
        }

        // Appointment composable
        composable(Routes.Booking.route){
            Booking()
        }

        // Account composable
        composable(Routes.Account.route){
            Account()
        }

        composable(Routes.AddService.route){
            AddService()
        }
    }
}

// new BottomBar for testing new implementation
@Composable
fun NewBottomBar(navController: NavHostController){
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        // handling state for each item selected on bottom bar
        BottomNavItems.BottomItems.forEach { navItem ->
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