package com.zszurman.liczniki

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DocumentViewHolder -> {
                holder.hold(list[position])
            }
        }
    }

    fun acceptList(osobyList: List<Counter>) {
        list = osobyList
    }
}

class DocumentViewHolder(context: Context, holder: View) : RecyclerView.ViewHolder(holder) {

    private val inscription = holder.tv
    private val rInit = holder.tv1
    private val rEnd = holder.tv2
    private val mV1 = holder.meterView1
    private val mV2 = holder.meterView2

    fun hold(counter: Counter) {
        inscription.text = counter.makeString()
        mV1.value = counter.initialState
        mV2.value = counter.endState
    }

    init {
        rInit.setOnClickListener {
            Toast.makeText(context, "Wprowadzono stały odczyt", Toast.LENGTH_SHORT).show()
        }
        rEnd.setOnClickListener {
            Toast.makeText(context, "Wprowadzono aktualny odczyt", Toast.LENGTH_SHORT).show()
        }

    }
}




