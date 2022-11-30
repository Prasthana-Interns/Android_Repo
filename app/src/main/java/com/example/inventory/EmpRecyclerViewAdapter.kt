package com.example.inventory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employee_tab_view.view.*

class EmpRecyclerViewAdapter(var empList:List<EmployeeData>): RecyclerView.Adapter<EmpRecyclerViewAdapter.myViewHolder>() {

    class myViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var empId:TextView=view.empId
        var empName:TextView=view.empName
        var designation:TextView=view.designation
        var nameIcon:TextView=view.nameIcon
        var nxtBtn:ImageView=view.nxtBtn

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.employee_tab_view,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.empId.text=empList[position].empId.toString()
        holder.empName.text=empList[position].name.toString()
        holder.designation.text=empList[position].designation.toString()
        holder.nameIcon.text=customIcon(empList[position].name.toString()).toUpperCase()
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,EmpDetailsScreen::class.java)
            intent.putExtra("id",empList[position].empId)
            intent.putExtra("name",empList[position].name)
            intent.putExtra("email",empList[position].email)
            intent.putExtra("phNum",empList[position].phoneNumber)
            intent.putExtra("designation",empList[position].designation)
            intent.putExtra("nameIcon",customIcon(empList[position].name.toString()).toUpperCase())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return empList.size
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