package com.zszurman.liczniki

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zszurman.liczniki.MainActivity.X.list
import kotlinx.android.synthetic.main.activity_edition.*
import kotlin.math.roundToInt

@Suppress("DEPRECATION")
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
        makeOnClick()
    }

    private fun setActionBar() {
        val mActionBar = supportActionBar
        mActionBar?.title = "Licznik nr " + (currentIdEt + 1).toString()
        mActionBar?.subtitle = "Przeglądaj i aktualizuj dane"
    }

    @SuppressLint("DefaultLocale")
    private fun makeEditText() {
        seekBar.progress = list[currentIdEt].vat
        seekBar1.progress = list[currentIdEt].dayMeasurement
        val x = "Licznik nr " + (currentIdEt + 1).toString()
        idEt.text = x
        nameEt.setText(list[currentIdEt].name)
        unitEt.setText(list[currentIdEt].unit)

        val x1 = list[currentIdEt].unitPrice.toDouble() / 100000
        upEt.text = x1.toString()

        val x2 = list[currentIdEt].fixedFess.toDouble() / 100
        cpEt.text = x2.toString()
        vatEt.text = list[currentIdEt].vat.toString()
        dayEt.text = list[currentIdEt].dayMeasurement.toString()

        when (list[currentIdEt].vat) {
            100 -> {
                plusBtn3.visibility = View.INVISIBLE
                minusBtn3.visibility = View.VISIBLE
            }
            0 -> {
                minusBtn3.visibility = View.INVISIBLE
                plusBtn3.visibility = View.VISIBLE
            }
            else -> {
                minusBtn3.visibility = View.VISIBLE
                plusBtn3.visibility = View.VISIBLE
            }
        }

        when (list[currentIdEt].dayMeasurement) {
            28 -> {
                plusBtn4.visibility = View.INVISIBLE
                minusBtn4.visibility = View.VISIBLE
            }
            1 -> {
                minusBtn4.visibility = View.INVISIBLE
                plusBtn4.visibility = View.VISIBLE
            }
            else -> {
                minusBtn4.visibility = View.VISIBLE
                plusBtn4.visibility = View.VISIBLE
            }
        }
    }

    private fun makeOnClick() {
        btnEt.setOnClickListener {
            when {
                nameEt.text.toString().isEmpty() -> Toast.makeText(
                    this,
                    "Wpisz nazwę licznika",
                    Toast.LENGTH_LONG
                ).show()
                unitEt.text.toString().isEmpty() -> Toast.makeText(
                    this,
                    "Wpisz jednostkę miary licznika",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    updateData()
                    Toast.makeText(this, "Dane zaktualizowano", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
        btnEt1.setOnClickListener {
            Toast.makeText(this, "Nie zaktualizowano danych", Toast.LENGTH_LONG).show()
            finish()
        }
        plusBtn1.setOnClickListener {

            val x = (upEt.text.toString().toDouble() * 100000).roundToInt()
            val y = if (sumEt1.text.isNullOrEmpty()) 0
            else (sumEt1.text.toString().toDouble() * 100000).roundToInt()
            val z = x + y
            val z1 = (z.toDouble()) / 100000
            upEt.text = z1.toString()
            sumEt1.setText("")
        }
        delBtn1.setOnClickListener {
            upEt.text = getString(R.string.zero5)
            sumEt1.setText("")
        }
        plusBtn2.setOnClickListener {
            val x = (cpEt.text.toString().toDouble() * 100).roundToInt()
            val y = if (sumEt2.text.isNullOrEmpty()) 0
            else (sumEt2.text.toString().toDouble() * 100).roundToInt()
            val z = x + y
            val z1 = (z.toDouble()) / 100
            cpEt.text = z1.toString()
            sumEt2.setText("")
        }
        delBtn2.setOnClickListener {
            cpEt.text = getString(R.string.zero2)
            sumEt2.setText("")
        }
        seekBar.max = 100
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.min = 0
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                vatEt.text = i.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                when (seekBar.progress) {
                    100 -> {
                        plusBtn3.visibility = View.INVISIBLE
                        minusBtn3.visibility = View.VISIBLE
                    }
                    0 -> {
                        minusBtn3.visibility = View.INVISIBLE
                        plusBtn3.visibility = View.VISIBLE
                    }
                    else -> {
                        minusBtn3.visibility = View.VISIBLE
                        plusBtn3.visibility = View.VISIBLE
                    }
                }
            }
        })

        minusBtn3.setOnClickListener {
            plusBtn3.visibility = View.VISIBLE
            var x = vatEt.text.toString().toInt()
            if (x > 0) x -= 1
            vatEt.text = x.toString()
            seekBar.progress = x
            if (x == 0) minusBtn3.visibility = View.INVISIBLE

        }
        plusBtn3.setOnClickListener {
            minusBtn3.visibility = View.VISIBLE
            var x = vatEt.text.toString().toInt()
            if (x < 100) x += 1
            vatEt.text = x.toString()
            seekBar.progress = x
            if (x == 100) plusBtn3.visibility = View.INVISIBLE
        }

        seekBar1.max = 28
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar1.min = 1
        }

        seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                dayEt.text = i.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

                when (seekBar.progress) {
                    28 -> {
                        plusBtn4.visibility = View.INVISIBLE
                        minusBtn4.visibility = View.VISIBLE
                    }
                    1 -> {
                        minusBtn4.visibility = View.INVISIBLE
                        plusBtn4.visibility = View.VISIBLE
                    }
                    else -> {
                        minusBtn4.visibility = View.VISIBLE
                        plusBtn4.visibility = View.VISIBLE
                    }
                }

            }
        })

        minusBtn4.setOnClickListener {
            plusBtn4.visibility = View.VISIBLE
            var x = dayEt.text.toString().toInt()
            if (x > 1) x -= 1
            dayEt.text = x.toString()
            seekBar1.progress = x
            if (x == 1) minusBtn4.visibility = View.INVISIBLE

        }
        plusBtn4.setOnClickListener {
            minusBtn4.visibility = View.VISIBLE
            var x = dayEt.text.toString().toInt()
            if (x < 28) x += 1
            dayEt.text = x.toString()
            seekBar1.progress = x
            if (x == 28) plusBtn4.visibility = View.INVISIBLE
        }
    }

    private fun updateData() {
        val a = nameEt.text.toString()
        val b = unitEt.text.toString()

        val x1 = upEt.text.toString().toDouble() * 100000
        val x = x1.roundToInt()

        val y1 = cpEt.text.toString().toDouble() * 100
        val y = y1.roundToInt()

        val c = vatEt.text.toString().toInt()
        val d = dayEt.text.toString().toInt()

        when (currentIdEt) {
            0 -> {
                Data.name1 = a
                Data.unit1 = b
                Data.uP1 = x
                Data.cP1 = y
                Data.vat1 = c
                Data.day1 = d
            }
            1 -> {
                Data.name2 = a
                Data.unit2 = b
                Data.uP2 = x
                Data.cP2 = y
                Data.vat2 = c
                Data.day2 = d
            }
            2 -> {
                Data.name3 = a
                Data.unit3 = b
                Data.uP3 = x
                Data.cP3 = y
                Data.vat3 = c
                Data.day3 = d
            }
            3 -> {
                Data.name4 = a
                Data.unit4 = b
                Data.uP4 = x
                Data.cP4 = y
                Data.vat4 = c
                Data.day4 = d
            }
        }
        Preference.setAllPref(this)
    }
}
