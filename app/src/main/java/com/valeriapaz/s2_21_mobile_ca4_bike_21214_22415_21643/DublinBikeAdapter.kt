package com.valeriapaz.s2_21_mobile_ca4_bike_21214_22415_21643

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_bike.view.*

class DublinBikeAdapter(val bikesList: List<BikesModels>) :
    RecyclerView.Adapter<DublinBikeAdapter.BikeViewHolder>() {

    // Adapter for the bikes RecyclerView

    inner class BikeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bike, parent, false)
        return BikeViewHolder(view)
    }

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) {

        val bike = bikesList[position]

        holder.itemView.tvStationNames.text = bike.name
        holder.itemView.tvBikesAvailable.text = bike.available_bikes.toString() + " available"

    }

    override fun getItemCount(): Int {
        return bikesList.size
    }
}

