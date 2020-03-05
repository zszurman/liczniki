package com.zszurman.liczniki

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.zszurman.liczniki.EditionActivity.Edit.currentIdEt
import com.zszurman.liczniki.MainActivity.X.currentId
import com.zszurman.liczniki.MainActivity.X.currentName
import com.zszurman.liczniki.MainActivity.X.currentSubtitle
import com.zszurman.liczniki.MainActivity.X.measurement
import com.zszurman.liczniki.MainActivity.X.screen
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
    private val nam = holder.nameTv
    private val unit = holder.unitTv
    private val up = holder.upTv
    private val cp = holder.cpTv
    private val vat = holder.vatTv
    private val day = holder.dayTv

    fun hold(counter: Counter) {
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
            screen = 1
            measurement = n1.text.toString().toInt()
            currentId = id.text.toString().toInt()
            currentName = nam.text.toString()
            currentSubtitle = context.getString(R.string.p0)
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        n2.setOnClickListener {
            screen = 1
            measurement = n2.text.toString().toInt()
            currentId = id.text.toString().toInt() + 10
            currentName = nam.text.toString()
            currentSubtitle = context.getString(R.string.p1)
            val intent = Intent(context, MainActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
        inscription.setOnClickListener {
            currentIdEt = id.text.toString().toInt()
            val intent = Intent(context, EditionActivity::class.java)
            startActivity(context, intent, bundleOf())
        }
    }
}




