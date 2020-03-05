package com.zszurman.liczniki

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
import com.zszurman.liczniki.Data.p01
import com.zszurman.liczniki.Data.p02
import com.zszurman.liczniki.Data.p03
import com.zszurman.liczniki.Data.p04
import com.zszurman.liczniki.Data.p11
import com.zszurman.liczniki.Data.p12
import com.zszurman.liczniki.Data.p13
import com.zszurman.liczniki.Data.p14
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
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {


    companion object X {
        var measurement = 0
        var screen = 0
        var currentId = 100
        var currentName = ""
        var currentSubtitle = ""
        var cC = 1
        lateinit var cardViewAdapter: CardViewAdapter
        lateinit var list: ArrayList<Counter>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (screen == 1) finish()
        layoutAlex.visibility = View.INVISIBLE

        getPref()
        initRecyclerView()
        btn.setOnClickListener {
            measurement = meterView.value
            when (currentId) {
                0 -> p01 = meterView.value
                10 -> p11 = meterView.value
                1 -> p02 = meterView.value
                11 -> p12 = meterView.value
                2 -> p03 = meterView.value
                12 -> p13 = meterView.value
                3 -> p04 = meterView.value
                13 -> p14 = meterView.value
            }
            setPref()
            currentId = 100
            onResume()
            layoutAlex.visibility = View.INVISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        meterView.value = measurement
        initRecyclerView()
        setActionBar(currentId)
        if (screen == 1) layoutAlex.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        setPref()
        screen = 0
    }

    private fun initRecyclerView() {
        list = Data.makeList()
        rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 1)
            cardViewAdapter = CardViewAdapter(this@MainActivity)
            adapter = cardViewAdapter
            cardViewAdapter.acceptList(list)
            cardViewAdapter.notifyDataSetChanged()
        }
    }

    private fun setActionBar(id: Int) {
        val mActionBar = supportActionBar
        if (id == 100 && cC ==1) {
            currentName = "Masz 1 licznik"
            currentSubtitle = "Kliknij odczyty by je zmieniać"
        }
        else if (id == 100) currentName = "Masz $cC liczniki"
        mActionBar?.title = currentName
        mActionBar?.subtitle = currentSubtitle
    }

    private fun getPref() {
        val pref = Preference(this)

        name1 = pref.getName1().toString()
        unit1 = pref.getUnit1().toString()
        uP1 = pref.getUP1()
        cP1 = pref.getCP1()
        vat1 = pref.getVat1()
        p01 = pref.getP01()
        p11 = pref.getP11()
        day1 = pref.getDay1()

        name2 = pref.getName2().toString()
        unit2 = pref.getUnit2().toString()
        uP2 = pref.getUP2()
        cP2 = pref.getCP2()
        vat2 = pref.getVat2()
        p02 = pref.getP02()
        p12 = pref.getP12()
        day2 = pref.getDay2()

        name3 = pref.getName3().toString()
        unit3 = pref.getUnit3().toString()
        uP3 = pref.getUP3()
        cP3 = pref.getCP3()
        vat3 = pref.getVat3()
        p03 = pref.getP03()
        p13 = pref.getP13()
        day3 = pref.getDay3()

        name4 = pref.getName4().toString()
        unit4 = pref.getUnit4().toString()
        uP4 = pref.getUP4()
        cP4 = pref.getCP4()
        vat4 = pref.getVat4()
        p04 = pref.getP04()
        p14 = pref.getP14()
        day4 = pref.getDay4()

        cC = pref.getCC()
    }

    private fun setPref() {
        val pref = Preference(this)
        pref.setP01(p01)
        pref.setP11(p11)
        pref.setP02(p02)
        pref.setP12(p12)
        pref.setP03(p03)
        pref.setP13(p13)
        pref.setP04(p04)
        pref.setP14(p14)
        pref.setCC(cC)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.action_sort -> showSortDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSortDialog() {
        val pref = Preference(this)
        val sortOptions =
            arrayOf("1 licznik","2 liczniki","3 liczniki","4 liczniki")
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Wybierz ilość liczników")
        mBuilder.setIcon(R.mipmap.ic_launcher)
        mBuilder.setSingleChoiceItems(sortOptions, -1) { dialogInterface, i ->
            when (i) {
                0 -> { cC = 1
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 1 licznik", Toast.LENGTH_SHORT).show()

                }
                1 -> { cC = 2
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 2 liczniki", Toast.LENGTH_SHORT).show()

                }

                2 -> { cC = 3
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 3 liczniki", Toast.LENGTH_SHORT).show()

                }
                3 -> { cC = 4
                    pref.setCC(cC)
                    onResume()
                    Toast.makeText(this, "Masz 4 liczniki", Toast.LENGTH_SHORT).show()
                }

            }
            dialogInterface.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()

    }

}

