package com.example.salonbooking

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.salonbooking.ui.theme.SalonBookingTheme
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SalonBookingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    MainScreen()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.bookAppointment))
                },
            )
        },
        bottomBar = { BottomBar() }
    ) {

        PickDate()

        PickTime()


    }

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

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PickDate() {


    val context = LocalContext.current

    // declaring variables day, month, year
    val day: Int
    val month: Int
    val year: Int

    // Initializing a Calendar
    val calen = Calendar.getInstance()


    year = calen.get(Calendar.YEAR)
    month = calen.get(Calendar.MONTH)
    day = calen.get(Calendar.DAY_OF_MONTH)

    calen.time = Date()


    val dateVal = remember { mutableStateOf("") }


    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            dateVal.value = "$day-${month + 1}-$year"
        }, year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "Select Date")

        Button(onClick = {
            mDatePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "Pick Date", color = Color.White)
        }

        // Adding a space after button
        Spacer(
            modifier = Modifier
                .size(15.dp)
        )

        Text(text = "Selected Date: ${dateVal.value}")
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PickTime() {


    val context = LocalContext.current

    // Initializing a Calendar
    val calen = Calendar.getInstance()

    // declaring variables minute, hour
    val minute = calen[Calendar.MINUTE]
    val hour = calen[Calendar.HOUR_OF_DAY]

//    calen.time = Date()


    val timeVal = remember { mutableStateOf("") }


    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, minute: Int ->
            timeVal.value = "$hour:$minute"
        }, hour, minute, false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 150.dp)
    ) {

        Text(text = "Select Time")

        Button(onClick = {
            timePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "Pick Time", color = Color.White)
        }

        // Adding a space after button
        Spacer(
            modifier = Modifier
                .size(15.dp)
        )

        Text(text = "Selected Time: ${timeVal.value}")

    }
}



@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SalonBookingTheme {
        MainScreen()
    }
}