package com.zszurman.liczniki

import android.annotation.SuppressLint
import java.lang.String.format

object Data {
    private const val id1 = 0
    var name1 = "Licznik wody"
    var unit1 = "m^3"
    var uP1 = 519000 + 702000
    var cP1 = 1040 + 316
    var vat1 = 8
    var p01 = 0
    var p11 = 0
    var day1 = 5

    private const val id2 = 1
    var name2 = "Licznik energii nr 94"
    var unit2 = "kWh"
    var uP2 = 24310 + 16910 + 139
    var cP2 = 1504 + 600 + 500 + 33 + 38
    var vat2 = 23
    var p02 = 0
    var p12 = 0
    var day2 = 5

    private const val id3 = 2
    var name3 = "Licznik energii nr 95"
    var unit3 = "kWh"
    var uP3 = 24310 + 16910 + 139
    var cP3 = 1504 + 600 + 750 + 33 + 38
    var vat3 = 23
    var p03 = 0
    var p13 = 0
    var day3 = 5

    private const val id4 = 3
    var name4 = "Licznik Baleno"
    var unit4 = "km"
    var uP4 = 498
    var cP4 = 0
    var vat4 = 0
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
    var unitPrice: Int,
    var fixedFess: Int,
    var vat: Int,
    var initialState: Int,
    var endState: Int,
    var dayMeasurement: Int
) {
    private val vatOk = 1 + vat.toDouble() / 100

    private fun calculateWear(): Int {
        return endState - initialState
    }

    private fun calculatePriceWear(): Double {
        return calculateWear().toDouble() * unitPrice.toDouble() * vatOk / 100000
    }

    private fun currentAcount(): Double {
        return calculatePriceWear() + (fixedFess.toDouble() * vatOk / 100)
    }

    private fun forecastAcount(): Double {
        val par = Parameter(dayMeasurement)
        return calculatePriceWear() * par.calculateParameter() + (fixedFess.toDouble() * vatOk / 100)
    }

    @SuppressLint("DefaultLocale")
    fun makeString(): String {
        val s1 = format("%.2f", calculatePriceWear())
        val s2 = format("%.2f", currentAcount())
        val s3 = format("%.2f", forecastAcount())

        return """${id + 1}. $name
-  -  -  -  -
Odczyt $dayMeasurement dnia m-ca = $initialState $unit
Odczyt aktualny = $endState $unit
-  -  -  -  -
Aktualne zużycie = ${calculateWear()} $unit
Aktualny koszt = $s1 zł.
Aktualny rachunek = $s2 zł. (wraz z opłatami stałymi)
-  -  -  -  - 
Prognozowany 
rachunek miesięczny = $s3 zł."""
    }
}