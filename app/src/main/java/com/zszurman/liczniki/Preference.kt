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
}
