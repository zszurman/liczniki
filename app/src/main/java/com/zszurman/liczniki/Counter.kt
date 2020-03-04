package com.zszurman.liczniki

import android.annotation.SuppressLint
import java.lang.String.format

object Data {
    private const val id1 = 0
    var name1 = "Licznik wody"
    var unit1 = "m^3"
    var uP1 = 5.19 + 7.02
    var cP1 = 10.4 + 3.16
    var vat1 = 8
    var p01 = 0
    var p11 = 0
    var day1 = 5

    private const val id2 = 1
    var name2 = "Licznik energii nr 94"
    var unit2 = "kWh"
    var uP2 = 0.2431 + 0.1691 + 0.00139
    var cP2 = 15.04 + 6 + 5 + 0.33 + 0.38
    var vat2 = 23
    var p02 = 0
    var p12 = 0
    var day2 = 5

    private const val id3 = 2
    var name3 = "Licznik energii nr 95"
    var unit3 = "kWh"
    var uP3 = 0.2431 + 0.1691 + 0.00139
    var cP3 = 15.04 + 6 + 7.5 + 0.33 + 0.38
    var vat3 = 23
    var p03 = 0
    var p13 = 0
    var day3 = 5

    fun makeList(): ArrayList<Counter> {
        val list = ArrayList<Counter>()
        list.add(Counter(id1, name1, unit1, uP1, cP1, vat1, p01, p11, day1))
        list.add(Counter(id2, name2, unit2, uP2, cP2, vat2, p02, p12, day2))
        list.add(Counter(id3, name3, unit3, uP3, cP3, vat3, p03, p13, day3))
        return list
    }
}

class Counter(
    var id: Int,
    var name: String,
    var unit: String,
    var unitPrice: Double,
    var fixedFess: Double,
    var vat: Int,
    var initialState: Int,
    var endState: Int,
    var dayMeasurement: Int
) {
    private val vatOk = 1.0 + vat.toDouble() / 100

    private fun calculateWear(): Int {
        return endState - initialState
    }

    private fun calculatePriceWear(): Double {
        return (calculateWear().toDouble()) * unitPrice * vatOk
    }

    private fun currentAcount(): Double {
        return calculatePriceWear() + (fixedFess * vatOk)
    }

    private fun forecastAcount(): Double {
        val par = Parameter(dayMeasurement)
        return calculatePriceWear() * par.calculateParameter() + (fixedFess * vatOk)
    }

    @SuppressLint("DefaultLocale")
    fun makeString(): String {
        val s1 = format("%.2f", calculatePriceWear())
        val s2 = format("%.2f", currentAcount())
        val s3 = format("%.2f", forecastAcount())
        return """${id + 1}. $name
odczyt = $initialState ($dayMeasurement dnia m-ca)
akt. odczyt = $endState
akt. zużycie = ${calculateWear()} $unit ($s1 zł.)
akt. rachunek = $s2 zł.
prog. rachunek = $s3 zł."""
    }
}