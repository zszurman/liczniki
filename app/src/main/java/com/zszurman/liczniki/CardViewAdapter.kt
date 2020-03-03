package com.zszurman.liczniki

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        return list.size
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

    private val inscription = holder.tv
    private val n1 = holder.tn1
    private val n2 = holder.tn2
    private val id = holder.idTv

    fun hold(counter: Counter) {
        inscription.text = counter.makeString()
        n1.text = counter.initialState.toString()
        n2.text = counter.endState.toString()
        id.text = counter.id.toString()
    }

    init {
        n1.setOnClickListener {
            MainActivity.d = 1
            MainActivity.l = n1.text.toString().toInt()
            MainActivity.id = id.text.toString().toInt()
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        n2.setOnClickListener {
            MainActivity.d = 1
            MainActivity.l = n2.text.toString().toInt()
            MainActivity.id = id.text.toString().toInt() + 10
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
    }
}




