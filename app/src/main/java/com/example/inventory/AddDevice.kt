package com.example.inventory

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.inventory.ConstantsValues.Companion.spinnerHeightValue
import com.example.inventory.ConstantsValues.Companion.nameValue
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.databinding.ActivityAddDeviceBinding
import com.example.inventory.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_add_device.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.reflect.Field



class AddDevice : AppCompatActivity() {
    private lateinit var binding: ActivityAddDeviceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        binding = ActivityAddDeviceBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_device)
        nameFocusListener()
            deviceTypeFocusListener()
            osFocusListener()
            serviceTagFocusListener()
            binding.addBtn.setOnClickListener {
                addForm()
            }
    }

//    private fun inflate(layoutInflater: LayoutInflater): AddDeviceFragment {
//
//    }

        private fun serviceTagFocusListener() {
            binding.DeviceServiceTagEt.setOnFocusChangeListener{_, focused->
                if (!focused)
                {
                    binding.serviceTagreq.helperText=validServiceTag()
                }

            }
        }

        private fun validServiceTag(): String? {
            val serviceTagText = binding.DeviceServiceTagEt.toString()
            if(serviceTagText.length <= ConstantsValues.nameValue)
                return "serviceTag should not be empty"
            else{
                return null
            }
        }

        private fun osFocusListener() {
            binding.osEt.setOnFocusChangeListener{_, focused->
                if (!focused)
                {
                    binding.osReq.helperText=validOs()
                }

            }
        }

        private fun validOs(): String? {
            val osText = binding.DeviceServiceTagEt.toString()
            if(osText.length <= ConstantsValues.nameValue)
                return "os should not be empty"
            else
            {
                return null
            }


        }

        private fun addDetails() {
        }

        private fun nameFocusListener()
        {
            binding.deviceNameEt.setOnFocusChangeListener{_, focused->
                if(!focused)
                {
                    binding.deviceNameReq.helperText=validdevicename()
                }

            }
        }

        private fun validdevicename(): String?
        {
            val nameText = binding.deviceNameEt.text.toString()
            if(nameText.length <= ConstantsValues.nameValue)
            {
                return "name is required"
            }
            return null
        }
        private fun deviceTypeFocusListener()
        {
            binding.deviceTypeEditText.setOnFocusChangeListener{_, focused->
                if(!focused)
                {
                    binding.deviceTypeReq.helperText=validDeviceType()
                }
            }
        }

        private fun validDeviceType(): String? {
            val deviceTypeText = binding.deviceTypeEditText.text.toString()
            if(deviceTypeText.length <= ConstantsValues.nameValue)
                return "deviceType is required"
            else
                return null

        }

        private fun addForm() {
            binding.serviceTagreq.helperText=validServiceTag()
            binding.deviceNameReq.helperText=validdevicename()
            binding.deviceTypeReq.helperText=validDeviceType()
            binding.osReq.helperText=validOs()
            val validServiceTag = binding.serviceTagreq.helperText == null
            val validdevicename = binding.deviceNameReq.helperText == null
            val validDeviceType = binding.deviceTypeReq.helperText == null
            val validOs = binding.osReq.helperText == null
            if(validServiceTag  && validdevicename && validDeviceType && validOs)
                resetForm()
            else
                invalidForm()
        }

        private fun invalidForm() {
            var message=" "
            if (binding.serviceTagreq.helperText != null)
                message += "\n\ntag: " + binding.serviceTagreq.helperText
            if (binding.deviceNameReq.helperText != null)
                message += "\n\ndevice name: "+ binding.deviceNameReq.helperText
            if (binding.deviceTypeReq.helperText != null)
                message += "\n\ntype: " + binding.deviceTypeReq.helperText
            if (binding.osReq.helperText != null)
                message += "\n\nos: "+ binding.osReq.helperText
            AlertDialog.Builder(this)
                .setTitle("Invalid Form")
                .setMessage(message)
                .setPositiveButton("okay"){_,_->

                }
        }

        private fun resetForm() {
            var message=" "
            message += "\n\ntag: " + binding.serviceTagreq.helperText
            message += "\n\ndevice name: "+ binding.deviceNameReq.helperText
            message += "\n\ntype: " + binding.deviceTypeReq.helperText
            message += "\n\nos: "+ binding.osReq.helperText
            AlertDialog.Builder(this)
                .setTitle("device added")
                .setMessage(message)
                .setPositiveButton("okay") { _, _ ->
                    binding.deviceNameEt.text = null
                    binding.osEt.text = null
                    binding.DeviceServiceTagEt.text = null
                    binding.deviceTypeEditText.text = null

                }

        }


    }
