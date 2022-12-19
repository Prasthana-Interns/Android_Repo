package com.example.inventory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.device_tab_view.view.*


class DevicesRecyclerViewAdapter( var DevicesList:MutableList<DevicesData>):
    RecyclerView.Adapter<DevicesRecyclerViewAdapter.myViewHolder>() {
//    var onItemClick : ((DevicesData)->Unit)? = null
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
//        val deviceData = DevicesList[position]
        holder.deviceName.text=DevicesList[position].deviceName.toString()
        holder.deviceType.text=DevicesList[position].deviceType.toString()
        holder.deviceTag.text=DevicesList[position].deviceServiceTag.toString()
        holder.deviceOS.text=DevicesList[position].deviceOperatingSystem.toString()
        holder.click_here_to_assign.setOnClickListener{
                val intent=Intent(holder.itemView.context,EmpBottombarActivity::class.java)
//            intent.putExtra("name",empList[position].name)

            holder.itemView.context.startActivity(intent)
            }
    //        holder.itemView.setOnClickListener(){
//            onItemClick?.invoke(deviceData)
//           //  onItemClick?.invoke()
//        }

    }
    override fun getItemCount(): Int {
        return DevicesList.size


    }
//    class ViewHolder(ItemView: View) :
//        RecyclerView.ViewHolder(ItemView) {
//        var deviceName:TextView = itemView.findViewById(R.id.deviceName)
//        var click_here_to_assign:TextView=itemView.findViewById(R.id.click_here_to_assign)
//        var deviceType:TextView=itemView.findViewById(R.id.deviceType)
//        var deviceOperatingSystem:TextView=itemView.findViewById(R.id.deviceOS)
//        var deviceServiceTag:TextView=itemView.findViewById(R.id.DeviceServiceTagEt)
//
//        //  val ll: LinearLayout = itemView.findViewById(R.id.cv_scheme)
//
//    }
}

