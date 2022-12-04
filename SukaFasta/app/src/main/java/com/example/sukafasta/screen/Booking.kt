package com.example.sukafasta.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sukafasta.model.Appointment
import com.example.sukafasta.ui.theme.primaryColor
import java.util.*
import com.example.sukafasta.R
import com.example.sukafasta.model.AppointmentViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Booking(viewModel: AppointmentViewModel){
    val context = LocalContext.current
//    val viewModel: AppointmentViewModel = viewModel();
    val selectedDate = remember {
        mutableStateOf("")
    }
    val selectedTime = remember {
        mutableStateOf("")
    }
    val selectedService = remember {
        mutableStateOf("")
    }
    PickDate(selectedDate, selectedTime, selectedService)

    PickTime(selectedDate, selectedTime, selectedService)

    SelectService(context, selectedDate, selectedTime, selectedService, {viewModel.add(it)})
}

// handles picking date during appointment setting
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PickDate(selectedDate: MutableState<String>, selectedTime: MutableState<String>, selectedService: MutableState<String>) {

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
        selectedDate.value = dateVal.value}, year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Select Date")

            Button(
                onClick = {
                    mDatePickerDialog.show()
                }, colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
                modifier = Modifier.padding(start = 189.dp)
            ) {
                Text(text = "Pick Date", color = Color.White)
            }
        }

        // Adding a space after button
        Spacer(
            modifier = Modifier
                .size(15.dp)
        )

        Text(text = "Selected Date: ${dateVal.value}")
    }
}

// handles picking time while setting up appointment
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PickTime(selectedDate: MutableState<String>, selectedTime: MutableState<String>, selectedService: MutableState<String>) {

    val context = LocalContext.current

    // Initializing a Calendar
    val calen = Calendar.getInstance()

    // declaring variables minute, hour
    val minute = calen[Calendar.MINUTE]
    val hour = calen[Calendar.HOUR_OF_DAY]

    val timeVal = remember { mutableStateOf("") }

    // creating timepicker dialog
    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, minute: Int ->
            timeVal.value = "$hour:$minute"
        selectedTime.value = timeVal.value}, hour, minute, false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 130.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Select Time")

            Button(
                onClick = {
                    timePickerDialog.show()
                }, colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
                modifier = Modifier.padding(start = 183.dp)
            ) {
                Text(text = "Pick Time", color = Color.White)
            }
        }

        // Adding a space after button
        Spacer(
            modifier = Modifier
                .size(15.dp)
        )

        Text(text = "Selected Time: ${timeVal.value}")

    }
}

// displays radio buttons to choose service during appointment booking
@Composable
fun SelectService(context: Context, selectedDate: MutableState<String>, selectedTime: MutableState<String>, selectedService: MutableState<String>, addAppointment: (Appointment) -> Unit) {
    // list of radio buttons
    val servicesOptions = listOf("Braiding", "Hair Cut", "Make Up", "Manicure")
    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf(servicesOptions[0])
    }

    Column(
        Modifier
            .selectableGroup()
            .padding(start = 20.dp, top = 240.dp)
    ) {
        Text(text = "Select Service:")

        // radio buttons menu group starts here
        servicesOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = (text == selectedOption),
                    onClick = {selectedService.value = selectedOption} // null recommended for accessibility with screenreaders
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

        }

        Text(
            text = "Selected Service: ${selectedOption}",
            modifier = Modifier.padding(top = 15.dp)
        )
        Spacer(modifier = Modifier.size(50.dp))

        //Submit Button
        Button(
            onClick = {
                val newID = UUID.randomUUID().toString();
                addAppointment(Appointment(newID, selectedService.value, selectedDate.value, selectedTime.value))
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.appointmentAdded),
                    Toast.LENGTH_SHORT
                ).show()
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)
                .height(45.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Confirm Appointment", color = Color.White, fontSize = 18.sp)
        }

    }

}

