package com.zszurman.liczniki

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.NumberPicker.OnValueChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.alexzaitsev.meternumberpicker.MeterNumberPicker
import com.zszurman.liczniki.Data.p941
import com.zszurman.liczniki.Data.p942
import com.zszurman.liczniki.Data.p951
import com.zszurman.liczniki.Data.p952
import com.zszurman.liczniki.Data.w1
import com.zszurman.liczniki.Data.w2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var list: ArrayList<Counter>
    private lateinit var cardViewAdapter: CardViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPref()
        initRecyclerView()
    }

    private fun setPref() {
        val pref = Preference(this)
        w1 = pref.getPrefW1()
        w2 = pref.getPrefW2()
        p941 = pref.getPref941()
        p942 = pref.getPref942()
        p951 = pref.getPref951()
        p952 = pref.getPref952()
        list = Data.makeList()
    }

    private fun initRecyclerView() {
        list = Data.makeList()
        rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 1)
            cardViewAdapter = CardViewAdapter(this@MainActivity)
            adapter = cardViewAdapter
            cardViewAdapter.acceptList(list)
            cardViewAdapter.notifyDataSetChanged()
            val mActionBar = supportActionBar
            if (mActionBar != null) {
                mActionBar.title = resources.getString(R.string.text1)
                mActionBar.subtitle = resources.getString(R.string.text2)
            }
        }
    }

}
