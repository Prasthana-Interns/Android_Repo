package com.example.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_devices.*

class DevicesFragment : Fragment() {
        private var DevicesDetails: ArrayList<DevicesData>? = null
    private var DeviceAdapter: DevicesRecyclerViewAdapter? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_devices)
//        val recyclerview = findViewById<RecyclerView>(R.id.dfrecyclerView)
//        val cardView = findViewById<Button>(R.id.assign)
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.setHasFixedSize(true)
//        val data = ArrayList<DevicesData>()
//        var DevicesRecyclerViewAdapter = DevicesRecyclerViewAdapter(data)
//        var adapter = DevicesRecyclerViewAdapter
//        recyclerview.adapter = adapter
//        DevicesRecyclerViewAdapter.onItemClick = {
//            val dialog = BottomSheetDialog(this)
//            val view = layoutInflater.inflate(R.layout.fragment_devices, null)
//            val btnClose = view.findViewById<Button>(R.id.assign)
//            btnClose.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.setCancelable(true)
//            dialog.setCanceledOnTouchOutside(true)
//            dialog.setContentView(view)
//            dialog.show()
//            Toast.makeText(this@DevicesFragment, "Device Assigned", Toast.LENGTH_SHORT).show()
//        }
//
//}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        dfrecyclerView.setHasFixedSize(true)
        dfrecyclerView.layoutManager = LinearLayoutManager(activity)
        DevicesDetails = ArrayList()
        DevicesDetails?.add(DevicesData(
                "Macbook Pro 13",
                "Laya Boini",
                "Laptop",
                "Mac OS",
                "ABC123"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Dell",
                "Pranith Sangeetha",
                "Laptop",
                "Windows",
                "QWER123"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Lenova Bag",
                "Chaitanya Balanagu",
                "Bag",
                "Lenova",
                "A123"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "milton",
                "Swarna Mamindla",
                "Water Bottle",
                "xyz",
                "BC123"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Iqoo Z6 Pro",
                "mayur chowhan",
                "mobile",
                "vivo",
                "C123"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Boat Blutooth",
                "Hari Krishna",
                "Head Phones",
                "boaaat",
                "A23"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Hp",
                "Shiva Kumar",
                "Laptop",
                "Linux",
                "ASDF234"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "Kinley",
                "Umar md",
                "Water Bottle",
                "JKMKL",
                "2134SD"

            )
        )
        DevicesDetails?.add(
            DevicesData(
                "HP",
                "Narendra b",
                "Mobile",
                "vghbjn",
                "ABfcgvhC123"

            )
        )
        DeviceAdapter = DevicesRecyclerViewAdapter(DevicesDetails!!)
        dfrecyclerView.adapter = DeviceAdapter
    }
}
