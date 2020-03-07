package com.zszurman.liczniki

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edition.*
import java.lang.String.format

@Suppress("DEPRECATION")
class EditionActivity : AppCompatActivity() {

    companion object Edit {
        var currentIdEt = 0
        var a = MainActivity.list[currentIdEt].name
        var b = MainActivity.list[currentIdEt].unit
        var c = MainActivity.list[currentIdEt].unitPrice
        var d = MainActivity.list[currentIdEt].fixedFess
        var e = MainActivity.list[currentIdEt].vat
        var f = MainActivity.list[currentIdEt].dayMeasurement
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
        plusBtn1.setOnClickListener {
            val x = upEt.text.toString().toFloat()
            val y = if (sumEt1.text.isNullOrEmpty()) 0.0f
            else sumEt1.text.toString().toFloat()
            val z = x + y
            upEt.text = z.toString()
            sumEt1.setText("")
        }
        delBtn1.setOnClickListener {
            upEt.text = getString(R.string.zero)
            sumEt1.setText("")
        }
        plusBtn2.setOnClickListener {
            val x = cpEt.text.toString().toFloat()
            val y = if (sumEt2.text.isNullOrEmpty()) 0.0f
            else sumEt2.text.toString().toFloat()
            val z = x + y
            cpEt.text = z.toString()
            sumEt2.setText("")
        }
        delBtn2.setOnClickListener {
            cpEt.text = getString(R.string.zero)
            sumEt2.setText("")
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
        nameEt.setText(a)
        unitEt.setText(b)
        upEt.text = c.toString()
        cpEt.text = format("%.2f", d)
        vatEt.setText(format("%.1f", e))
        dayEt.setText(f.toString())
    }

    private fun updateData() {
        when (currentIdEt) {
            0 -> {
                Data.name1 = nameEt.text.toString()
                Data.unit1 = unitEt.text.toString()
                Data.uP1 = upEt.text.toString().toFloat()
                Data.cP1 = cpEt.text.toString().toFloat()
                Data.vat1 = vatEt.text.toString().toFloat()
                Data.day1 = dayEt.text.toString().toInt()
            }
            1 -> {
                Data.name2 = nameEt.text.toString()
                Data.unit2 = unitEt.text.toString()
                Data.uP2 = upEt.text.toString().toFloat()
                Data.cP2 = cpEt.text.toString().toFloat()
                Data.vat2 = vatEt.text.toString().toFloat()
                Data.day2 = dayEt.text.toString().toInt()
            }
            2 -> {
                Data.name3 = nameEt.text.toString()
                Data.unit3 = unitEt.text.toString()
                Data.uP3 = upEt.text.toString().toFloat()
                Data.cP3 = cpEt.text.toString().toFloat()
                Data.vat3 = vatEt.text.toString().toFloat()
                Data.day3 = dayEt.text.toString().toInt()
            }
            3 -> {
                Data.name4 = nameEt.text.toString()
                Data.unit4 = unitEt.text.toString()
                Data.uP4 = upEt.text.toString().toFloat()
                Data.cP4 = cpEt.text.toString().toFloat()
                Data.vat4 = vatEt.text.toString().toFloat()
                Data.day4 = dayEt.text.toString().toInt()
            }
        }
        Preference.setAllPref(this)
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
            vatEt.text.toString().toFloat() in 0..100 &&
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
            vatEt.text.toString().toFloat() !in 0..100 -> {
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
