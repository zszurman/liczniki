package com.zszurman.liczniki

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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

    companion object X {
        var l = 0
        var d = 0
        var id = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ll.visibility = View.INVISIBLE

        if (d == 1) finish()
        getPref()
        initRecyclerView()
        btn.setOnClickListener {
            l = meterView.value
            when (id) {
                0 -> w1 = meterView.value
                10 -> w2 = meterView.value
                1 -> p941 = meterView.value
                11 -> p942 = meterView.value
                2 -> p951 = meterView.value
                12 -> p952 = meterView.value
            }
            setPref()
            onResume()
            ll.visibility = View.INVISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        meterView.value = l
        initRecyclerView()
        if (d == 1) {
            ll.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        setPref()
    }

    private fun getPref() {
        val pref = Preference(this)
        w1 = pref.getPrefW1()
        w2 = pref.getPrefW2()
        p941 = pref.getPref941()
        p942 = pref.getPref942()
        p951 = pref.getPref951()
        p952 = pref.getPref952()
    }

    private fun setPref() {
        val pref = Preference(this)
        pref.setPrefW1(w1)
        pref.setPrefW2(w2)
        pref.setPref941(p941)
        pref.setPref942(p942)
        pref.setPref951(p951)
        pref.setPref952(p952)

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
