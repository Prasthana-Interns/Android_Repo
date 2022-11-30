package com.example.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_employee.*

class FragmentOne : Fragment() {
    private var empDetails: ArrayList<EmployeeData>? = null
    private var searchEmpDetails: ArrayList<EmployeeData>? = null
    private var EmployeeAdapter: EmpRecyclerViewAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onViewCreated(itemView: View,savedInstanceState: Bundle?) {
        super.onViewCreated(itemView,savedInstanceState)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(activity)

        empDetails=ArrayList()

        empDetails?.add(EmployeeData(
            "EmpId-001",
            "Praneeth Sangita",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")
        ))
        empDetails?.add(EmployeeData(
            "EmpId-002",
            "Krishna Sangita",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-003",
            "Laya Boini",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-004",
            "Hari Krishna",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-005",
            "Mayur chowhan",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-006",
            "Chaitanya BalaNagu",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-001",
            "Praneeth Sangita",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-002",
            "Krishna Sangita",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData("EmpId-003",
            "Laya Boini",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-004",
            "Hari Krishna",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-005",
            "Mayur chowhan",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))
        empDetails?.add(EmployeeData(
            "EmpId-006",
            "Chaitanya BalaNagu",
            "Developer",
            967617464,
            "praneethsangita@gmail.com",
            arrayOf("Laptop","Bag")))

        EmployeeAdapter=EmpRecyclerViewAdapter(empDetails!!)
        recyclerView.adapter=EmployeeAdapter

    }



}