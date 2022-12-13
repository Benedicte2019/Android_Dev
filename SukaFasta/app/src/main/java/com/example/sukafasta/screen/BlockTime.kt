package com.example.sukafasta.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sukafasta.R
import com.example.sukafasta.model.TimeBlocked
import java.util.*

//class BlockTime {
//}

// allows hairdresser to block time
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BlockTime(addBlockedTime: (TimeBlocked) -> Unit) {
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    )
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(20.dp)) {
            Row() {
                Text(modifier = Modifier
                    .padding(10.dp),
                    text = "Selected Date: ${startDate.value}")
                Button(onClick = { mDatePickerDialog.show() }) {
                    Text(text = "Pick Date")
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Row() {
                Text(modifier = Modifier
                    .padding(10.dp),
                    text = "Selected Time: ${startTime.value}")
                Button(onClick = { timePickerDialog.show() }) {
                    Text(text = "Pick Time")
                }

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    val newID = UUID.randomUUID().toString();
                    addBlockedTime(TimeBlocked(newID, "", startDate.value, startTime.value))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.date_blocked),
                        Toast.LENGTH_SHORT
                    ).show()
                },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp,
                    hoveredElevation = 15.dp,
                    focusedElevation = 10.dp
                ),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(50.dp)
                    .border(1.dp, MaterialTheme.colors.secondary, RoundedCornerShape(30.dp))
            ) {
                Text(
                    text = "Block",
                    fontSize = 20.sp
                )
            }
        }
    }
}