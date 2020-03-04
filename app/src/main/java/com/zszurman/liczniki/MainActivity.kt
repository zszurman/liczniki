package com.zszurman.liczniki

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.zszurman.liczniki.Data.p01
import com.zszurman.liczniki.Data.p02
import com.zszurman.liczniki.Data.p03
import com.zszurman.liczniki.Data.p11
import com.zszurman.liczniki.Data.p12
import com.zszurman.liczniki.Data.p13
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<Counter>
    private lateinit var cardViewAdapter: CardViewAdapter

    companion object X {
        var measurement = 0
        var screen = 0
        var currentId = 100
        var currentName = ""
        var currentSubtitle = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutAlex.visibility = View.INVISIBLE
        if (screen == 1) finish()
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

    private fun setActionBar(id:Int) {
        val mActionBar = supportActionBar
        if (id == 100) {
            currentName = "Liczniki"
            currentSubtitle = "Kliknij odczyty by je zmieniać"
        }
        mActionBar?.title = currentName
        mActionBar?.subtitle = currentSubtitle
    }

    private fun getPref() {
        val pref = Preference(this)
        p01 = pref.getP01()
        p11 = pref.getP11()
        p02 = pref.getP02()
        p12 = pref.getP12()
        p03 = pref.getP03()
        p13 = pref.getP13()
    }

    private fun setPref() {
        val pref = Preference(this)
        pref.setP01(p01)
        pref.setP11(p11)
        pref.setP02(p02)
        pref.setP12(p12)
        pref.setP03(p03)
        pref.setP13(p13)
    }
}
