package com.zszurman.liczniki

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class CardViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: List<Counter> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DocumentViewHolder(
            context,
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return MainActivity.cC
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DocumentViewHolder -> {
                holder.hold(list[position])
            }
        }
    }

    fun acceptList(counterList: List<Counter>) {
        list = counterList
    }
}

class DocumentViewHolder(context: Context, holder: View) : RecyclerView.ViewHolder(holder) {

    private val edBt = holder.editBtn
    private val upTv = holder.tvUp
    private val upBt = holder.upBtn
    private val inscription = holder.tv
    private val n1 = holder.tn1
    private val n2 = holder.tn2
    private val id = holder.idTv
    private val nam = holder.nameTv
    private val unit = holder.unitTv
    private val up = holder.upTv
    private val cp = holder.cpTv
    private val vat = holder.vatTv
    private val day = holder.dayTv

    fun hold(counter: Counter) {

        if (counter.id == 0) {
            upBt.visibility = View.INVISIBLE
            upTv.visibility = View.INVISIBLE
        }
        inscription.text = counter.makeString()
        n1.text = counter.initialState.toString()
        n2.text = counter.endState.toString()
        id.text = counter.id.toString()
        nam.text = counter.name
        unit.text = counter.unit
        up.text = counter.unitPrice.toString()
        cp.text = counter.fixedFess.toString()
        vat.text = counter.vat.toString()
        day.text = counter.dayMeasurement.toString()
    }

    init {
        n1.setOnClickListener {
            MainActivity.screen = 1
            MainActivity.alexVisible = 1
            MainActivity.measurement = n1.text.toString().toInt()
            MainActivity.currentId = id.text.toString().toInt()
            MainActivity.currentName = nam.text.toString()
            MainActivity.currentSubtitle = context.getString(R.string.p0)
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        n2.setOnClickListener {
            MainActivity.screen = 1
            MainActivity.alexVisible = 1
            MainActivity.measurement = n2.text.toString().toInt()
            MainActivity.currentId = id.text.toString().toInt() + 10
            MainActivity.currentName = nam.text.toString()
            MainActivity.currentSubtitle = context.getString(R.string.p1)
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        edBt.setOnClickListener {
            EditionActivity.currentIdEt = id.text.toString().toInt()
            val intent = Intent(context, EditionActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        upBt.setOnClickListener {

            val nr = id.text.toString().toInt()
            if (nr > 0) {
                val b1 = Data.name1
                val c1 = Data.unit1
                val d1 = Data.uP1
                val e1 = Data.cP1
                val f1 = Data.vat1
                val g1 = Data.day1
                val i1 = Data.p01
                val j1 = Data.p11

                val b2 = Data.name2
                val c2 = Data.unit2
                val d2 = Data.uP2
                val e2 = Data.cP2
                val f2 = Data.vat2
                val g2 = Data.day2
                val i2 = Data.p02
                val j2 = Data.p12

                val b3 = Data.name3
                val c3 = Data.unit3
                val d3 = Data.uP3
                val e3 = Data.cP3
                val f3 = Data.vat3
                val g3 = Data.day3
                val i3 = Data.p03
                val j3 = Data.p13

                val b4 = Data.name4
                val c4 = Data.unit4
                val d4 = Data.uP4
                val e4 = Data.cP4
                val f4 = Data.vat4
                val g4 = Data.day4
                val i4 = Data.p04
                val j4 = Data.p14

                if (nr == 1) {
                    Data.name2 = b1
                    Data.unit2 = c1
                    Data.uP2 = d1
                    Data.cP2 = e1
                    Data.vat2 = f1
                    Data.day2 = g1
                    Data.p02 = i1
                    Data.p12 = j1

                    Data.name1 = b2
                    Data.unit1 = c2
                    Data.uP1 = d2
                    Data.cP1 = e2
                    Data.vat1 = f2
                    Data.day1 = g2
                    Data.p01 = i2
                    Data.p11 = j2
                }
                if (nr == 2) {
                    Data.name3 = b2
                    Data.unit3 = c2
                    Data.uP3 = d2
                    Data.cP3 = e2
                    Data.vat3 = f2
                    Data.day3 = g2
                    Data.p03 = i2
                    Data.p13 = j2

                    Data.name2 = b3
                    Data.unit2 = c3
                    Data.uP2 = d3
                    Data.cP2 = e3
                    Data.vat2 = f3
                    Data.day2 = g3
                    Data.p02 = i3
                    Data.p12 = j3
                }
                if (nr == 3) {
                    Data.name4 = b3
                    Data.unit4 = c3
                    Data.uP4 = d3
                    Data.cP4 = e3
                    Data.vat4 = f3
                    Data.day4 = g3
                    Data.p04 = i3
                    Data.p14 = j3

                    Data.name3 = b4
                    Data.unit3 = c4
                    Data.uP3 = d4
                    Data.cP3 = e4
                    Data.vat3 = f4
                    Data.day3 = g4
                    Data.p03 = i4
                    Data.p13 = j4
                }
                Preference.setAllPref(context)
                MainActivity.screen = 1
                MainActivity.alexVisible = 0
                val intent = Intent(context, MainActivity::class.java)
                startActivity(context, intent, bundleOf())
            }
        }
    }
}







