package com.example.inventory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.device_tab_view.view.*


class DevicesRecyclerViewAdapter( var DevicesList:MutableList<DevicesData>): RecyclerView.Adapter<DevicesRecyclerViewAdapter.myViewHolder>() {
    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName: TextView = view.deviceName
        val deviceType: TextView = view.deviceType
        val deviceAssignedTo: TextView = view.deviceAssignedTo
        val deviceOS: TextView = view.deviceOS
        val deviceTag: TextView = view.deviceTag


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.device_tab_view, parent, false)
        return DevicesRecyclerViewAdapter.myViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
