package com.example.inventory

import android.os.Parcel
import android.os.Parcelable

data class EmployeeData(
    var empId:String?,
    var name:String?,
    var designation:String?,
    var phoneNumber:Int?,
    var email:String?,
    var devices:Array<String>?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.createStringArray()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(empId)
        parcel.writeString(name)
        parcel.writeString(designation)
        parcel.writeValue(phoneNumber)
        parcel.writeString(email)
        parcel.writeStringArray(devices)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmployeeData> {
        override fun createFromParcel(parcel: Parcel): EmployeeData {
            return EmployeeData(parcel)
        }

        override fun newArray(size: Int): Array<EmployeeData?> {
            return arrayOfNulls(size)
        }
    }
}
