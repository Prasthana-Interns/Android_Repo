package com.example.inventory

import android.bluetooth.BluetoothClass.Device
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.device_tab_view.view.*
import kotlinx.android.synthetic.main.activity_add_device.view.*


class DevicesRecyclerViewAdapter( var DevicesList:MutableList<DevicesData>):
    RecyclerView.Adapter<DevicesRecyclerViewAdapter.myViewHolder>() {
    var onItemClick : ((DevicesData)->Unit)? = null
    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName: TextView = view.deviceName
        val deviceType: TextView = view.deviceType
        val click_here_to_assign: TextView = view.click_here_to_assign
        val deviceOS: TextView = view.deviceOS
        val deviceTag: TextView = view.deviceTag
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView =LayoutInflater.from(parent.context).inflate(R.layout.device_tab_view, parent, false)
        return myViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val deviceData = DevicesList[position]
        holder.deviceName.text=DevicesList[position].deviceName.toString()
        holder.deviceType.text=DevicesList[position].deviceType.toString()
        holder.click_here_to_assign.text=DevicesList[position].click_here_to_assign.toString()
        holder.deviceTag.text=DevicesList[position].deviceServiceTag.toString()
        holder.deviceOS.text=DevicesList[position].deviceOperatingSystem.toString()
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(deviceData)
           //  onItemClick?.invoke()
        }

    }
    override fun getItemCount(): Int {
        return DevicesList.size


    }
    class ViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView) {
        var deviceName:TextView = itemView.findViewById(R.id.deviceName)
        var click_here_to_assign:TextView=itemView.findViewById(R.id.click_here_to_assign)
        var deviceType:TextView=itemView.findViewById(R.id.deviceType)
        var deviceOperatingSystem:TextView=itemView.findViewById(R.id.deviceOS)
        var deviceServiceTag:TextView=itemView.findViewById(R.id.DeviceServiceTagEt)

        //  val ll: LinearLayout = itemView.findViewById(R.id.cv_scheme)

    }
}


