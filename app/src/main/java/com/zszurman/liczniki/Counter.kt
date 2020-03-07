package com.zszurman.liczniki

import android.annotation.SuppressLint
import java.lang.String.format

object Data {
    private const val id1 = 0
    var name1 = "Licznik wody"
    var unit1 = "m^3"
    var uP1 = 5.19f + 7.02f
    var cP1 = 10.4f + 3.16f
    var vat1 = 8f
    var p01 = 0
    var p11 = 0
    var day1 = 5

    private const val id2 = 1
    var name2 = "Licznik energii nr 94"
    var unit2 = "kWh"
    var uP2 = 0.2431f + 0.1691f + 0.00139f
    var cP2 = 15.04f + 6.0f + 5.0f + 0.33f + 0.38f
    var vat2 = 23f
    var p02 = 0
    var p12 = 0
    var day2 = 5

    private const val id3 = 2
    var name3 = "Licznik energii nr 95"
    var unit3 = "kWh"
    var uP3 = 0.2431f + 0.1691f + 0.00139f
    var cP3 = 15.04f + 6.0f + 7.5f + 0.33f + 0.38f
    var vat3 = 23f
    var p03 = 0
    var p13 = 0
    var day3 = 5

    private const val id4 = 3
    var name4 = "Licznik Baleno"
    var unit4 = "km"
    var uP4 = 4.98f
    var cP4 = 0.0f
    var vat4 = 0f
    var p04 = 1000
    var p14 = 1100
    var day4 = 1

    fun makeList(): ArrayList<Counter> {
        val list = ArrayList<Counter>()
        list.add(Counter(id1, name1, unit1, uP1, cP1, vat1, p01, p11, day1))
        list.add(Counter(id2, name2, unit2, uP2, cP2, vat2, p02, p12, day2))
        list.add(Counter(id3, name3, unit3, uP3, cP3, vat3, p03, p13, day3))
        list.add(Counter(id4, name4, unit4, uP4, cP4, vat4, p04, p14, day4))
        return list
    }
}

class Counter(
    var id: Int,
    var name: String,
    var unit: String,
    var unitPrice: Float,
    var fixedFess: Float,
    var vat: Float,
    var initialState: Int,
    var endState: Int,
    var dayMeasurement: Int
) {
    private val vatOk = 1 + vat.toDouble() / 100

    private fun calculateWear(): Int {
        return endState - initialState
    }

    private fun calculatePriceWear(): Double {
        return calculateWear().toDouble() * unitPrice.toDouble() * vatOk
    }

    private fun currentAcount(): Double {
        return calculatePriceWear() + (fixedFess.toDouble() * vatOk)
    }

    private fun forecastAcount(): Double {
        val par = Parameter(dayMeasurement)
        return calculatePriceWear() * par.calculateParameter() + (fixedFess.toDouble() * vatOk)
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