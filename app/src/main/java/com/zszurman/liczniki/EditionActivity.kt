package com.zszurman.liczniki

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zszurman.liczniki.Data.cP1
import com.zszurman.liczniki.Data.cP2
import com.zszurman.liczniki.Data.cP3
import com.zszurman.liczniki.Data.cP4
import com.zszurman.liczniki.Data.day1
import com.zszurman.liczniki.Data.day2
import com.zszurman.liczniki.Data.day3
import com.zszurman.liczniki.Data.day4
import com.zszurman.liczniki.Data.name1
import com.zszurman.liczniki.Data.name2
import com.zszurman.liczniki.Data.name3
import com.zszurman.liczniki.Data.name4
import com.zszurman.liczniki.Data.uP1
import com.zszurman.liczniki.Data.uP2
import com.zszurman.liczniki.Data.uP3
import com.zszurman.liczniki.Data.uP4
import com.zszurman.liczniki.Data.unit1
import com.zszurman.liczniki.Data.unit2
import com.zszurman.liczniki.Data.unit3
import com.zszurman.liczniki.Data.unit4
import com.zszurman.liczniki.Data.vat1
import com.zszurman.liczniki.Data.vat2
import com.zszurman.liczniki.Data.vat3
import com.zszurman.liczniki.Data.vat4
import kotlinx.android.synthetic.main.activity_edition.*
import java.lang.String.format

class EditionActivity : AppCompatActivity() {

    companion object Edit {
        var currentIdEt = 0
    }

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edition)

        makeEditText()
        setActionBar()
        btnEt.setOnClickListener {
            makeToast()
            if (condition()) {
                updateData()
                finish()
            }
        }
        btnEt1.setOnClickListener {
            Toast.makeText(this, "Nie zaktualizowano danych", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun setActionBar() {
        val mActionBar = supportActionBar

        mActionBar?.title = "Licznik nr " + (currentIdEt + 1).toString()
        mActionBar?.subtitle = "Przeglądaj i aktualizuj dane"
    }

    @SuppressLint("DefaultLocale")
    private fun makeEditText() {
        val x = "Licznik nr " + (currentIdEt + 1).toString()
        idEt.text = x
        when (currentIdEt) {
            0 -> {
                nameEt.setText(name1)
                unitEt.setText(unit1)
                upEt.setText(uP1.toString())
                cpEt.setText(format("%.2f", cP1))
                vatEt.setText(vat1.toString())
                dayEt.setText(day1.toString())
            }

            1 -> {
                nameEt.setText(name2)
                unitEt.setText(unit2)
                upEt.setText(uP2.toString())
                cpEt.setText(format("%.2f", cP2))
                vatEt.setText(vat2.toString())
                dayEt.setText(day2.toString())
            }
            2 -> {
                nameEt.setText(name3)
                unitEt.setText(unit3)
                upEt.setText(uP3.toString())
                cpEt.setText(format("%.2f", cP3))
                vatEt.setText(vat3.toString())
                dayEt.setText(day3.toString())
            }
            3 -> {
                nameEt.setText(name4)
                unitEt.setText(unit4)
                upEt.setText(uP4.toString())
                cpEt.setText(format("%.2f", cP4))
                vatEt.setText(vat4.toString())
                dayEt.setText(day4.toString())
            }
        }
    }

    private fun updateData() {
        val pref = Preference(this)
        when (currentIdEt) {
            0 -> {
                name1 = nameEt.text.toString()
                unit1 = unitEt.text.toString()
                uP1 = upEt.text.toString().toFloat()
                cP1 = cpEt.text.toString().toFloat()
                vat1 = vatEt.text.toString().toInt()
                day1 = dayEt.text.toString().toInt()

                pref.setName1(name1)
                pref.setUnit1(unit1)
                pref.setUP1(uP1)
                pref.setCP1(cP1)
                pref.setVat1(vat1)
                pref.setDay1(day1)
            }

            1 -> {
                name2 = nameEt.text.toString()
                unit2 = unitEt.text.toString()
                uP2 = upEt.text.toString().toFloat()
                cP2 = cpEt.text.toString().toFloat()
                vat2 = vatEt.text.toString().toInt()
                day2 = dayEt.text.toString().toInt()

                pref.setName2(name2)
                pref.setUnit2(unit2)
                pref.setUP2(uP2)
                pref.setCP2(cP2)
                pref.setVat2(vat2)
                pref.setDay2(day2)
            }
            2 -> {
                name3 = nameEt.text.toString()
                unit3 = unitEt.text.toString()
                uP3 = upEt.text.toString().toFloat()
                cP3 = cpEt.text.toString().toFloat()
                vat3 = vatEt.text.toString().toInt()
                day3 = dayEt.text.toString().toInt()

                pref.setName3(name3)
                pref.setUnit3(unit3)
                pref.setUP3(uP3)
                pref.setCP3(cP3)
                pref.setVat3(vat3)
                pref.setDay3(day3)
            }
            3 -> {
                name4 = nameEt.text.toString()
                unit4 = unitEt.text.toString()
                uP4 = upEt.text.toString().toFloat()
                cP4 = cpEt.text.toString().toFloat()
                vat4 = vatEt.text.toString().toInt()
                day4 = dayEt.text.toString().toInt()

                pref.setName4(name4)
                pref.setUnit4(unit4)
                pref.setUP4(uP4)
                pref.setCP4(cP4)
                pref.setVat4(vat4)
                pref.setDay4(day4)
            }
        }
    }

    private fun condition1(): Boolean {
        return !nameEt.text.isNullOrEmpty() &&
                !unitEt.text.isNullOrEmpty() &&
                !upEt.text.isNullOrEmpty() &&
                !cpEt.text.isNullOrEmpty() &&
                !vatEt.text.isNullOrEmpty() &&
                !dayEt.text.isNullOrEmpty()
    }

    private fun condition(): Boolean {
        return if (condition1()) {
            vatEt.text.toString().toInt() in 0..100 &&
                    dayEt.text.toString().toInt() in 1..28
        } else {
            false
        }
    }

    private fun makeToast() {
        when {
            nameEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz nazwę licznika", Toast.LENGTH_LONG).show()
            }
            unitEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz jednostkę pomiarową licznika", Toast.LENGTH_LONG).show()
            }
            upEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz sumę cen jednostkowych", Toast.LENGTH_LONG).show()
            }
            cpEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz sumę opłat stałych", Toast.LENGTH_LONG).show()
            }
            vatEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz podatek Vat", Toast.LENGTH_LONG).show()
            }
            dayEt.text.isNullOrEmpty() -> {
                Toast.makeText(this, "Wpisz dzień miesiąca odczytu początkowego", Toast.LENGTH_LONG)
                    .show()
            }
            vatEt.text.toString().toInt() !in 0..100 -> {
                Toast.makeText(this, "Vat: wprowadź wartość od 0 do 100", Toast.LENGTH_LONG).show()
            }
            dayEt.text.toString().toInt() !in 1..28 -> {
                Toast.makeText(
                    this,
                    "Dzień miesiąca wykonywania pomiaru początkowego: wprowadź wartość od 1 do 28",
                    Toast.LENGTH_LONG
                ).show()
            }
            else -> {
                Toast.makeText(this, "Dane zaktualizowano", Toast.LENGTH_LONG).show()
            }
        }
    }
}
