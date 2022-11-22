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
import androidx.compose.ui.input.key.Key
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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainScreen() {
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
                backgroundColor = Color(0XFF0F9D58),

                )
        },
        content = { NavigationHandler(navController = navController)},
        bottomBar = { NewBottomBar(navController = navController) }
    )
//    {

//        PickDate()
//
//        PickTime()
//
//        SelectService()

//    }

}

@Composable
fun BottomBar() {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "")
        },
            label = { Text(text = stringResource(id = R.string.homeIcon)) },
            selected = (selectedItem.value == 0),
            onClick = {
                selectedItem.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.DateRange, "")
        },
            label = { Text(text = stringResource(id = R.string.bookingIcon)) },
            selected = (selectedItem.value == 1),
            onClick = {
                selectedItem.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = stringResource(id = R.string.account)) },
            selected = (selectedItem.value == 2),
            onClick = {
                selectedItem.value = 2
            })
    }
}


// function to handle navigation
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavigationHandler(
    navController: NavHostController,
//    startDestination: String = "home"
){
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Home.route
    ){
        // Home composable
        composable(ScreenRoutes.Home.route){
            Home()
        }

        // Appointment composable
        composable(ScreenRoutes.Booking.route){
            Booking()
        }

        // Account composable
        composable(ScreenRoutes.Account.route){
            Account()
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