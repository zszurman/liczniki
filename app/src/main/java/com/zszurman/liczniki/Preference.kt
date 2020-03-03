package com.zszurman.liczniki

import android.content.Context

class Preference(context: Context) {
    private val pref = "pref"
    private val prefW1 = "prefW1"
    private val prefW2 = "prefW2"
    private val pref941 = "pref941"
    private val pref942 = "pref942"
    private val pref951 = "pref951"
    private val pref952 = "pref952"
    private val sharedPreferences = context.getSharedPreferences(pref, Context.MODE_PRIVATE)

    fun getPrefW1(): Int {
        return sharedPreferences.getInt(prefW1, 556)
    }

    fun setPrefW1(w1: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(prefW1, w1)
        editor.apply()
    }

    fun getPrefW2(): Int {
        return sharedPreferences.getInt(prefW2, 567)
    }

    fun setPrefW2(w2: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(prefW2, w2)
        editor.apply()
    }

    fun getPref941(): Int {
        return sharedPreferences.getInt(pref941, 33579)
    }

    fun setPref941(p941: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(pref941, p941)
        editor.apply()
    }

    fun getPref942(): Int {
        return sharedPreferences.getInt(pref942, 33783)
    }

    fun setPref942(p942: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(pref942, p942)
        editor.apply()
    }


    fun getPref951(): Int {
        return sharedPreferences.getInt(pref951, 4062)
    }

    fun setPref951(p951: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(pref951, p951)
        editor.apply()
    }

    fun getPref952(): Int {
        return sharedPreferences.getInt(pref952, 4117)
    }

    fun setPref952(p952: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(pref952, p952)
        editor.apply()
    }
}
