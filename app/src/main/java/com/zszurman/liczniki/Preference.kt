package com.zszurman.liczniki

import android.content.Context

class Preference(context: Context) {

    private val pref = "pref"
    private val p01 = "p01"
    private val p11 = "p11"
    private val p02 = "p02"
    private val p12 = "p12"
    private val p03 = "p03"
    private val p13 = "p13"

    private val name1 = "name1"
    private val unit1 = "unit1"
    private val uP1 = "uP1"
    private val cP1 = "cP1"
    private val vat1 = "vat1"
    private val day1 = "day1"

    private val name2 = "name2"
    private val unit2 = "unit2"
    private val uP2 = "uP2"
    private val cP2 = "cP2"
    private val vat2 = "vat2"
    private val day2 = "day2"

    private val name3 = "name3"
    private val unit3 = "unit3"
    private val uP3 = "uP3"
    private val cP3 = "cP3"
    private val vat3 = "vat3"
    private val day3 = "day3"

    private val sharedPreferences = context.getSharedPreferences(pref, Context.MODE_PRIVATE)


    fun getP01(): Int {
        return sharedPreferences.getInt(p01, 556)
    }

    fun setP01(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p01, i)
        editor.apply()
    }

    fun getP11(): Int {
        return sharedPreferences.getInt(p11, 567)
    }

    fun setP11(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p11, i)
        editor.apply()
    }

    fun getP02(): Int {
        return sharedPreferences.getInt(p02, 33579)
    }

    fun setP02(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p02, i)
        editor.apply()
    }

    fun getP12(): Int {
        return sharedPreferences.getInt(p12, 33783)
    }

    fun setP12(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p12, i)
        editor.apply()
    }

    fun getP03(): Int {
        return sharedPreferences.getInt(p03, 4062)
    }

    fun setP03(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p03, i)
        editor.apply()
    }

    fun getP13(): Int {
        return sharedPreferences.getInt(p13, 4117)
    }

    fun setP13(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(p13, i)
        editor.apply()
    }
    fun getName1(): String? {
        return sharedPreferences.getString(name1, "name1")
    }

    fun setName1(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name1, i)
        editor.apply()
    }

    fun getUnit1(): String? {
        return sharedPreferences.getString(unit1, "unit1")
    }

    fun setUnit1(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit1, i)
        editor.apply()
    }
    fun getUP1(): Float {
        return sharedPreferences.getFloat(uP1, 0.2222f)
    }

    fun setUP1(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP1, i)
        editor.apply()
    }

    fun getCP1(): Float {
        return sharedPreferences.getFloat(cP1, 0.2222f)
    }

    fun setCP1(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP1, i)
        editor.apply()
    }

    fun getVat1(): Int {
        return sharedPreferences.getInt(vat1, 8)
    }

    fun setVat1(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat1, i)
        editor.apply()
    }
    fun getDay1(): Int {
        return sharedPreferences.getInt(day1, 5)
    }

    fun setDay1(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day1, i)
        editor.apply()
    }

    fun getName2(): String? {
        return sharedPreferences.getString(name2, "name2")
    }

    fun setName2(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name2, i)
        editor.apply()
    }

    fun getUnit2(): String? {
        return sharedPreferences.getString(unit2, "unit2")
    }

    fun setUnit2(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit2, i)
        editor.apply()
    }
    fun getUP2(): Float {
        return sharedPreferences.getFloat(uP2, 0.2222f)
    }

    fun setUP2(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP2, i)
        editor.apply()
    }

    fun getCP2(): Float {
        return sharedPreferences.getFloat(cP2, 0.2222f)
    }

    fun setCP2(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP2, i)
        editor.apply()
    }

    fun getVat2(): Int {
        return sharedPreferences.getInt(vat2, 8)
    }

    fun setVat2(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat2, i)
        editor.apply()
    }
    fun getDay2(): Int {
        return sharedPreferences.getInt(day2, 5)
    }

    fun setDay2(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day2, i)
        editor.apply()
    }

    fun getName3(): String? {
        return sharedPreferences.getString(name3, "name3")
    }

    fun setName3(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(name3, i)
        editor.apply()
    }

    fun getUnit3(): String? {
        return sharedPreferences.getString(unit3, "unit3")
    }

    fun setUnit3(i: String) {
        val editor = sharedPreferences.edit()
        editor.putString(unit3, i)
        editor.apply()
    }
    fun getUP3(): Float {
        return sharedPreferences.getFloat(uP3, 0.2222f)
    }

    fun setUP3(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(uP3, i)
        editor.apply()
    }

    fun getCP3(): Float {
        return sharedPreferences.getFloat(cP3, 0.2222f)
    }

    fun setCP3(i: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(cP3, i)
        editor.apply()
    }

    fun getVat3(): Int {
        return sharedPreferences.getInt(vat3, 8)
    }

    fun setVat3(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(vat3, i)
        editor.apply()
    }
    fun getDay3(): Int {
        return sharedPreferences.getInt(day3, 5)
    }

    fun setDay3(i: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(day3, i)
        editor.apply()
    }
}





