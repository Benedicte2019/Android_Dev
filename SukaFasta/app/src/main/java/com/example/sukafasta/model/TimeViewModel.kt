package com.example.sukafasta.model

import androidx.lifecycle.ViewModel

class TimeViewModel: ViewModel() {
    var blockedTimeList = mutableListOf<TimeBlocked>()

    fun addBlockedDate(timeBlocked: TimeBlocked){
        blockedTimeList.add(timeBlocked)
    }

}