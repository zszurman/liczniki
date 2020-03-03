package com.zszurman.liczniki

import android.annotation.SuppressLint
import java.lang.String.format

object Data {
    private const val unitPriceW = 5.1 + 7.02
    private const val fixedFessW = 10.4 + 3.16
    private const val unitPriceP = 0.2431 + 0.1691 + 0.00139
    private const val fixedFessP94 = 15.04 + 5 + 6 + 0.33 + 0.38
    private const val fixedFessP95 = 15.04 + 6 + 7.5 + 0.33 + 0.38
    private const val vatW = 8
    private const val vatP = 23
    private const val dayMeasurement = 5
    private const val unitW = "m^3"
    private const val unitP = "kWh"
    var w1 = 0
    var w2 = 0
    var p941 = 0
    var p942 = 0
    var p951 = 0
    var p952 = 0
    fun makeList(): ArrayList<Counter> {
        val list = ArrayList<Counter>()
        list.add(
            Counter(
                0,
                "Licznik wody",
                unitW,
                w1,
                w2,
                dayMeasurement,
                unitPriceW,
                fixedFessW,
                vatW
            )
        )
        list.add(
            Counter(
                1,
                "Licznik prądu 94",
                unitP,
                p941,
                p942,
                dayMeasurement,
                unitPriceP,
                fixedFessP94,
                vatP
            )
        )
        list.add(
            Counter(
                2,
                "Licznik prądu 95",
                unitP,
                p951,
                p952,
                dayMeasurement,
                unitPriceP,
                fixedFessP95,
                vatP
            )
        )
        return list
    }
}


class Counter(
    var id: Int,
    private val name: String,
    private val unit: String,
    var initialState: Int,
    var endState: Int,
    private val dayMeasurement: Int,
    private val unitPrice: Double,
    private val fixedFess: Double,
    vat: Int
) {

    private val vatOk = 1.0 + vat.toDouble() / 100

    private fun calculateWear(): Int {
        return endState - initialState
    }

    private fun calculatePriceWear(): Double {
        return (calculateWear().toDouble()) * unitPrice * vatOk
    }

    private fun currentAcount(): Double {
        return calculatePriceWear() + fixedFess * vatOk
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
        return """${id +1}. $name
rozliczenie $dayMeasurement dnia m-ca
odczyt (O) -> $initialState
akt. odczyt (O1) - > $endState
akt. zużycie -> ${calculateWear()} $unit ($s1 zł.)
akt. rachunek -> $s2 zł.
prog. rachunek -> $s3 zł."""
    }
}