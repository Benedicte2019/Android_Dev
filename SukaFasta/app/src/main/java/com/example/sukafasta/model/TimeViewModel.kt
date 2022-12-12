package com.example.sukafasta.model

import androidx.lifecycle.ViewModel

class TimeViewModel: ViewModel() {
    var timeSlotsList = mutableListOf<TimeBlocked>()
}