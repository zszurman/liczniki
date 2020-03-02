package com.zszurman.liczniki

import android.content.Context

class Preference(context: Context) {
    private val pref = "pref"
    private val prefW1 = "prefW1"
    private val prefW2 = "preW2"
    private val pref941 = "pref941"
    private val pref942 = "pre942"
    private val pref951 = "pref941"
    private val pref952 = "pref952"
    private val preferencja = context.getSharedPreferences(pref, Context.MODE_PRIVATE)

    fun getPrefW1(): Int {
        return preferencja.getInt(prefW1, 556)
    }

    fun setPrefW1(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(prefW1, i)
        editor.apply()
    }

    fun getPrefW2(): Int {
        return preferencja.getInt(prefW2, 567)
    }

    fun setPrefW2(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(prefW2, i)
        editor.apply()
    }

    fun getPref941(): Int {
        return preferencja.getInt(pref941, 33579)
    }

    fun setPref941(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(pref941, i)
        editor.apply()
    }
    fun getPref942(): Int {
        return preferencja.getInt(pref942, 33783)
    }

    fun setPref942(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(pref942, i)
        editor.apply()
    }


    fun getPref951(): Int {
        return preferencja.getInt(pref951, 4062)
    }

    fun setPref951(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(pref951, i)
        editor.apply()
    }
    fun getPref952(): Int {
        return preferencja.getInt(pref952, 4117)
    }

    fun setPre952(i: Int) {
        val editor = preferencja.edit()
        editor.putInt(pref952, i)
        editor.apply()
    }
}
