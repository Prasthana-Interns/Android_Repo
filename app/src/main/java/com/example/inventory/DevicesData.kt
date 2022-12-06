package com.example.inventory

import android.os.Parcel
import android.os.Parcelable

data class DevicesData(
    var deviceName:String?,
    var click_here_to_assign:String?,
    var deviceType:String?,
    var deviceOperatingSystem: String?,
    var deviceServiceTag:String?
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(deviceName)
        parcel.writeString(click_here_to_assign)
        parcel.writeString(deviceType)
        parcel.writeString(deviceOperatingSystem)
        parcel.writeValue(deviceServiceTag)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DevicesData> {
        override fun createFromParcel(parcel: Parcel): DevicesData {
            return DevicesData(parcel)
        }

        override fun newArray(size: Int): Array<DevicesData?> {
            return arrayOfNulls(size)
        }
    }
}
