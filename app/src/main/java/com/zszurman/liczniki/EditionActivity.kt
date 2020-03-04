package com.zszurman.liczniki

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zszurman.liczniki.Data.cP1
import com.zszurman.liczniki.Data.cP2
import com.zszurman.liczniki.Data.cP3
import com.zszurman.liczniki.Data.day1
import com.zszurman.liczniki.Data.day2
import com.zszurman.liczniki.Data.day3
import com.zszurman.liczniki.Data.name1
import com.zszurman.liczniki.Data.name2
import com.zszurman.liczniki.Data.name3
import com.zszurman.liczniki.Data.uP1
import com.zszurman.liczniki.Data.uP2
import com.zszurman.liczniki.Data.uP3
import com.zszurman.liczniki.Data.unit1
import com.zszurman.liczniki.Data.unit2
import com.zszurman.liczniki.Data.unit3
import com.zszurman.liczniki.Data.vat1
import com.zszurman.liczniki.Data.vat2
import com.zszurman.liczniki.Data.vat3
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
        btnEt.setOnClickListener {
            updateData()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("DefaultLocale")
    private fun makeEditText() {
        idEt.text = (currentIdEt + 1).toString()
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
        }

    }

    private fun updateData(){
        when (currentIdEt) {
            0 -> {
                name1 = nameEt.text.toString()
                unit1 = unitEt.text.toString()
                uP1 = upEt.text.toString().toDouble()
                cP1 = cpEt.text.toString().toDouble()
                vat1 = vatEt.text.toString().toInt()
                day1 = dayEt.text.toString().toInt()
            }

            1 -> {
                name2 = nameEt.text.toString()
                unit2 = unitEt.text.toString()
                uP2 = upEt.text.toString().toDouble()
                cP2 = cpEt.text.toString().toDouble()
                vat2 = vatEt.text.toString().toInt()
                day2 = dayEt.text.toString().toInt()
            }
            2 -> {
                name3 = nameEt.text.toString()
                unit3 = unitEt.text.toString()
                uP3 = upEt.text.toString().toDouble()
                cP3 = cpEt.text.toString().toDouble()
                vat3 = vatEt.text.toString().toInt()
                day3 = dayEt.text.toString().toInt()
            }
        }

    }
}