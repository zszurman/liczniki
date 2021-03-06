package com.zszurman.liczniki

import android.annotation.SuppressLint
import android.os.Build
import java.lang.String.format
import java.util.*
import kotlin.collections.ArrayList

object Data {
    private const val id1 = 0
    var name1 = "Licznik wody"
    var unit1 = "m3"
    var uP1 = 519000 + 702000
    var cP1 = 1040 + 316
    var vat1 = 8
    var p01 = 356
    var p11 = 367
    var day1 = 2

    private const val id2 = 1
    var name2 = "Licznik energii elektrycznej"
    var unit2 = "kWh"
    var uP2 = 24310 + 16910 + 139
    var cP2 = 1504 + 600 + 500 + 33 + 38
    var vat2 = 23
    var p02 = 4117
    var p12 = 4189
    var day2 = 5

    private const val id3 = 2
    var name3 = "Licznik piwa"
    var unit3 = "butelek półlitrowych"
    var uP3 = 300000
    var cP3 = 500
    var vat3 = 0
    var p03 = 0
    var p13 = 45
    var day3 = 1

    private const val id4 = 3
    var name4 = "Licznik samochodowy"
    var unit4 = "km"
    var uP4 = 498000
    var cP4 = 10000
    var vat4 = 0
    var p04 = 127080
    var p14 = 131040
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

        val s1 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,.2f", calculatePriceWear())
        } else String.format("%.2f", calculatePriceWear())


        val s2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,.2f", currentAcount())
        } else String.format("%.2f", currentAcount())


        val s3 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,.2f", forecastAcount())
        } else String.format("%.2f", forecastAcount())


        val y1 = """$s1 zł."""
        val y2 = """$s2 zł. (wraz z opłatami stałymi)"""
        val y3 = """$s3 zł."""

        val z1 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,d", initialState)
        } else initialState.toString()


        val z2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,d", endState)
        } else endState.toString()


        val z3 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            format(Locale.forLanguageTag("PL"), "%,d", calculateWear())
        } else calculateWear().toString()


        return """${id + 1}. $name
-  -  -  -  -
Odczyt $dayMeasurement dnia m-ca = $z1 $unit
Odczyt aktualny = $z2 $unit
Przyrost = $z3 $unit
-  -  -  -  -
Aktualny koszt = $y1
Aktualny rachunek = $y2
-  -  -  -  - 
Prognozowany 
rachunek miesięczny = $y3"""
    }
}