package com.zszurman.liczniki

import java.util.*

class Parameter(private val dayMeasurement: Int) {

    private val today = Calendar.getInstance()
    private var day1 = Calendar.getInstance()
    private var day2 = Calendar.getInstance()
    private var par1 = 0
    private var par2 = 0
    private val dayOfYear = today.get(Calendar.DAY_OF_YEAR)
    private val dayOfMonth = today.get(Calendar.DAY_OF_MONTH)
    private var month = today.get(Calendar.MONTH)
    private var dayOfYear1 = 1
    private var dayOfYear2 = 1

    fun calculateParameter(): Double {
        if (dayMeasurement >= dayOfMonth && month != 0) // before dayMeasurement except January
        {
            day2.set(Calendar.MONTH, month)
            day2.set(Calendar.DAY_OF_MONTH, dayMeasurement)
            dayOfYear2 = day2.get(Calendar.DAY_OF_YEAR)

            day1.set(Calendar.MONTH, month - 1)
            day1.set(Calendar.DAY_OF_MONTH, dayMeasurement)
            dayOfYear1 = day1.get(Calendar.DAY_OF_YEAR)

            par1 = dayOfYear2 - dayOfYear1
            par2 = dayOfYear - dayOfYear1
        } else if (dayMeasurement >= dayOfMonth) // before dayMeasurement in January
        {
            par1 = 31
            par2 = 31 - dayMeasurement + dayOfMonth
        } else if (month != 11) // after dayMeasurement except December
        {
            day2.set(Calendar.MONTH, month + 1)
            day2.set(Calendar.DAY_OF_MONTH,dayMeasurement)
            dayOfYear2 = day2.get(Calendar.DAY_OF_YEAR)

            day1.set(Calendar.MONTH, month)
            day1.set(Calendar.DAY_OF_MONTH, dayMeasurement)
            dayOfYear1 = day1.get(Calendar.DAY_OF_YEAR)

            par1 = dayOfYear2 - dayOfYear1
            par2 = dayOfYear - dayOfYear1
        } else {                                 // after dayMeasurement in December
            par1 = 31
            par2 = dayOfMonth - dayMeasurement
        }
        return par1.toDouble() / par2.toDouble()
    }
}





