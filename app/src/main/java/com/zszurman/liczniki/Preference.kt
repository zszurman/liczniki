package com.zszurman.liczniki

import android.content.Context

class Preference(context: Context) {

    private val pref = "pref"

    private val name1 = "name1"
    private val unit1 = "unit1"
    private val uP1 = "uP1"
    private val cP1 = "cP1"
    private val vat1 = "vat1"
    private val p01 = "p01"
    private val p11 = "p11"
    private val day1 = "day1"

    private val name2 = "name2"
    private val unit2 = "unit2"
    private val uP2 = "uP2"
    private val cP2 = "cP2"
    private val vat2 = "vat2"
    private val p02 = "p02"
    private val p12 = "p12"
    private val day2 = "day2"

    private val name3 = "name3"
    private val unit3 = "unit3"
    private val uP3 = "uP3"
    private val cP3 = "cP3"
    private val vat3 = "vat3"
    private val p03 = "p03"
    private val p13 = "p13"
    private val day3 = "day3"

    private val name4 = "name4"
    private val unit4 = "unit4"
    private val uP4 = "uP4"
    private val cP4 = "cP4"
    private val vat4 = "vat4"
    private val p04 = "p04"
    private val p14 = "p14"
    private val day4 = "day4"

    private val cC = "cC"


    private val sharedPreferences = context.getSharedPreferences(pref, Context.MODE_PRIVATE)


    fun getName1(): String? {
        return sharedPreferences.getString(name1, Data.name1)
    }

    fun setName1(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name1, i)
        editor.apply()
    }

    fun getUnit1(): String? {
        return sharedPreferences.getString(unit1, Data.unit1)
    }

    fun setUnit1(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit1, i)
        editor.apply()
    }

    fun getUP1(): Float {
        return sharedPreferences.getFloat(uP1, Data.uP1)
    }

    fun setUP1(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP1, i)
        editor.apply()
    }

    fun getCP1(): Float {
        return sharedPreferences.getFloat(cP1, Data.cP1)
    }

    fun setCP1(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP1, i)
        editor.apply()
    }

    fun getVat1(): Int {
        return sharedPreferences.getInt(vat1, Data.vat1)
    }

    fun setVat1(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat1, i)
        editor.apply()
    }

    fun getP01(): Int {
        return sharedPreferences.getInt(p01, Data.p01)
    }

    fun setP01(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p01, i)
        editor.apply()
    }

    fun getP11(): Int {
        return sharedPreferences.getInt(p11, Data.p11)
    }

    fun setP11(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p11, i)
        editor.apply()
    }

    fun getDay1(): Int {
        return sharedPreferences.getInt(day1, Data.day1)
    }

    fun setDay1(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day1, i)
        editor.apply()
    }

    fun getName2(): String? {
        return sharedPreferences.getString(name2, Data.name2)
    }

    fun setName2(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name2, i)
        editor.apply()
    }

    fun getUnit2(): String? {
        return sharedPreferences.getString(unit2, Data.unit2)
    }

    fun setUnit2(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit2, i)
        editor.apply()
    }

    fun getUP2(): Float {
        return sharedPreferences.getFloat(uP2, Data.uP2)
    }

    fun setUP2(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP2, i)
        editor.apply()
    }

    fun getCP2(): Float {
        return sharedPreferences.getFloat(cP2, Data.cP2)
    }

    fun setCP2(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP2, i)
        editor.apply()
    }

    fun getVat2(): Int {
        return sharedPreferences.getInt(vat2, Data.vat2)
    }

    fun setVat2(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat2, i)
        editor.apply()
    }

    fun getP02(): Int {
        return sharedPreferences.getInt(p02, Data.p02)
    }

    fun setP02(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p02, i)
        editor.apply()
    }

    fun getP12(): Int {
        return sharedPreferences.getInt(p12, Data.p12)
    }

    fun setP12(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p12, i)
        editor.apply()
    }

    fun getDay2(): Int {
        return sharedPreferences.getInt(day2, Data.day2)
    }

    fun setDay2(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day2, i)
        editor.apply()
    }

    fun getName3(): String? {
        return sharedPreferences.getString(name3, Data.name3)
    }

    fun setName3(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name3, i)
        editor.apply()
    }

    fun getUnit3(): String? {
        return sharedPreferences.getString(unit3, Data.unit3)
    }

    fun setUnit3(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit3, i)
        editor.apply()
    }

    fun getUP3(): Float {
        return sharedPreferences.getFloat(uP3, Data.uP3)
    }

    fun setUP3(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP3, i)
        editor.apply()
    }

    fun getCP3(): Float {
        return sharedPreferences.getFloat(cP3, Data.cP3)
    }

    fun setCP3(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP3, i)
        editor.apply()
    }

    fun getVat3(): Int {
        return sharedPreferences.getInt(vat3, Data.vat3)
    }

    fun setVat3(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat3, i)
        editor.apply()
    }

    fun getP03(): Int {
        return sharedPreferences.getInt(p03, Data.p03)
    }

    fun setP03(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p03, i)
        editor.apply()
    }

    fun getP13(): Int {
        return sharedPreferences.getInt(p13, Data.p13)
    }

    fun setP13(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p13, i)
        editor.apply()
    }

    fun getDay3(): Int {
        return sharedPreferences.getInt(day3, Data.day3)
    }

    fun setDay3(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day3, i)
        editor.apply()
    }

    fun getName4(): String? {
        return sharedPreferences.getString(name4, Data.name4)
    }

    fun setName4(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name4, i)
        editor.apply()
    }

    fun getUnit4(): String? {
        return sharedPreferences.getString(unit4, Data.unit4)
    }

    fun setUnit4(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit4, i)
        editor.apply()
    }

    fun getUP4(): Float {
        return sharedPreferences.getFloat(uP4, Data.uP4)
    }

    fun setUP4(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP4, i)
        editor.apply()
    }

    fun getCP4(): Float {
        return sharedPreferences.getFloat(cP4, Data.cP4)
    }

    fun setCP4(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP4, i)
        editor.apply()
    }

    fun getVat4(): Int {
        return sharedPreferences.getInt(vat4, Data.vat4)
    }

    fun setVat4(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat4, i)
        editor.apply()
    }

    fun getP04(): Int {
        return sharedPreferences.getInt(p04, Data.p04)
    }

    fun setP04(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p04, i)
        editor.apply()
    }

    fun getP14(): Int {
        return sharedPreferences.getInt(p14, Data.p14)
    }

    fun setP14(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p14, i)
        editor.apply()
    }

    fun getDay4(): Int {
        return sharedPreferences.getInt(day4, Data.day4)
    }

    fun setDay4(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day4, i)
        editor.apply()
    }

    fun getCC(): Int {
        return sharedPreferences.getInt(cC, MainActivity.cC)
    }

    fun setCC(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(cC, i)
        editor.apply()
    }
}





