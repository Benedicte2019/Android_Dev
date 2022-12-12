package com.example.sukafasta.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.*

//class BlockTime {
//}

// allows hairdresser to block time
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BlockTime(
    ){
    /*Implement end time later*/

    val startDate = remember {
        mutableStateOf("")
    }

    val startTime = remember {
        mutableStateOf("")
    }
    // declare variables
    // for date picker

    val context = LocalContext.current

    // declaring variables day, month, year
    val day: Int
    val month: Int
    val year: Int

    // Initializing a Calendar
    val calen = Calendar.getInstance()

    // initialize date picker variables
    year = calen.get(Calendar.YEAR)
    month = calen.get(Calendar.MONTH)
    day = calen.get(Calendar.DAY_OF_MONTH)

    calen.time = Date()


    val dateVal = remember { mutableStateOf("") }


    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            dateVal.value = "$day-${month + 1}-$year"
            startDate.value = dateVal.value}, year, month, day
    )

    // restrict user from picking date from the past
    mDatePickerDialog.datePicker.minDate = calen.timeInMillis

    /* variables for time picker
    declare time picker variables
    declaring variables minute, hour.
    */

    val minute = calen[Calendar.MINUTE]
    val hour = calen[Calendar.HOUR_OF_DAY]

    val timeVal = remember { mutableStateOf("") }

    // creating timepicker dialog

    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, minute: Int ->
            timeVal.value = "$hour:$minute"
            startTime.value = timeVal.value}, hour, minute, false
    )

    /*
    * Creating the content of block time screen
    */
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Selected Date: $startTime")
        Button(onClick = { mDatePickerDialog.show() }) {
            Text(text = "Pick Date")
        }
        Text(text = "Selected Time: $startDate")
        Button(onClick = { timePickerDialog.show() }) {
            Text(text = "Pick Time")
        }
    }
}