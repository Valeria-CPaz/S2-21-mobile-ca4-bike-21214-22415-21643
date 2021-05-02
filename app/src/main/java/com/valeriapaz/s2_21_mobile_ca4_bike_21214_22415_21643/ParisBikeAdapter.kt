package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bike.view.*

class ParisBikeAdapter(val bikesListParis: List<BikesModels>) :
    RecyclerView.Adapter<ParisBikeAdapter.ParisBikeHolder>() {

    // Adapter for the bikes RecyclerView

    inner class ParisBikeHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParisBikeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bike, parent, false)
        return ParisBikeHolder(view)
    }

    override fun onBindViewHolder(holder: ParisBikeHolder, position2: Int) {

        val bike = bikesListParis[position2]

        holder.itemView.tvStationNames.text = bike.name
        holder.itemView.tvBikesAvailable.text = bike.available_bikes.toString() + " available"

    }

    override fun getItemCount(): Int {
        return bikesListParis.size
    }
}
