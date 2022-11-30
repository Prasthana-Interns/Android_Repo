package com.example.inventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_approvals.*
import kotlinx.android.synthetic.main.fragment_employee.*

class FragmentThree : Fragment() {

    var approvalsEmployeeDetails:ArrayList<ApprovalsData>?=null
    var approvalAdapter:ApprovalsRecyclerViewAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_approvals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apRecyclerView.setHasFixedSize(true)
        apRecyclerView.layoutManager= LinearLayoutManager(activity)

        approvalsEmployeeDetails= ArrayList()

        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-401",
            "Danniel Jacob",
            "Developer",
            "9676174645",
            "danny@gmail.com"))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-420",
            "Chaitanya Gupta",
            "Developer",
            "900645999",
            "chaitanya@gmail.com"
        ))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-401",
            "Danniel Jacob",
            "Developer",
            "9676174645",
            "danny@gmail.com"))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-420",
            "Chaitanya Gupta",
            "Developer",
            "900645999",
            "chaitanya@gmail.com"
        ))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-401",
            "Danniel Jacob",
            "Developer",
            "9676174645",
            "danny@gmail.com"))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-420",
            "Chaitanya Gupta",
            "Developer",
            "900645999",
            "chaitanya@gmail.com"
        ))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-401",
            "Danniel Jacob",
            "Developer",
            "9676174645",
            "danny@gmail.com"))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-420",
            "Chaitanya Gupta",
            "Developer",
            "900645999",
            "chaitanya@gmail.com"
        ))
        approvalsEmployeeDetails?.add(ApprovalsData(
            "EMPID-401",
            "Danniel Jacob",
            "Developer",
            "9676174645",
            "danny@gmail.com"))


        approvalAdapter=ApprovalsRecyclerViewAdapter(approvalsEmployeeDetails!!)
        apRecyclerView.adapter=approvalAdapter
    }
}