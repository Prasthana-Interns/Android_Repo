package com.example.inventory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.approvals_tab_view.view.*

class ApprovalsRecyclerViewAdapter(var approvalList:List<ApprovalsData>): RecyclerView.Adapter<ApprovalsRecyclerViewAdapter.myViewHolder>()  {
    class myViewHolder(view: View): RecyclerView.ViewHolder(view){
        var apEmpId=view.apEmpId
        var apEmpName=view.apEmpName
        var apdesignation=view.apDesignation
        var apNameIcon=view.apNameIcon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.approvals_tab_view,parent,false)
        return ApprovalsRecyclerViewAdapter.myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.apEmpId.text=approvalList[position].apEmpId.toString()
        holder.apEmpName.text=approvalList[position].apName.toString()
        holder.apdesignation.text=approvalList[position].apDesignation.toString()
        holder.apNameIcon.text=customIcon(approvalList[position].apName.toString()).uppercase()
    }

    override fun getItemCount(): Int {
        return approvalList.size
    }
    fun customIcon(name:String): String {
        var str1 = ""
        val delimiter = " "
        val parts = name.split(delimiter)
        for (ele in parts) {
            str1 += ele[0]
        }
        return str1
    }
}