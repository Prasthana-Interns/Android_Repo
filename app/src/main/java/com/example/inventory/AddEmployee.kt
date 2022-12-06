package com.example.inventory

import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.AdminScreenOne
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Intent
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import com.example.inventory.ConstantsValues.Companion.nameValue

import com.example.inventory.databinding.ActivityAddEmployeeBinding
import kotlinx.android.synthetic.main.activity_add_employee.*
import kotlinx.android.synthetic.main.activity_add_employee.spnTest
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.reflect.Field

class AddEmployee : AppCompatActivity() {
    private lateinit var binding : ActivityAddEmployeeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEmployeeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_employee)
        anameFocusListener()
        aemailFocusListener()
        adesignationFocusListener()
        aphoneNumberFocusListener()
        aEmpIdFocusListener()
        val list: MutableList<String> = ArrayList()

        list.add("admin")
        list.add("employee")
        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, list
        )
        spnTest.adapter = adapter
        spnTest.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item: String = list[position]
                Toast.makeText(this@AddEmployee, "$item selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        limitDropDownHeight(spnTest)
    }
    private fun limitDropDownHeight(spnTest: Spinner) {
        val popup: Field = Spinner::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val popupWindow: ListPopupWindow = popup.get(spnTest) as ListPopupWindow
        popupWindow.height = (ConstantsValues.spinnerHeightValue * resources.displayMetrics.density).toInt()

    }
    private fun addEmployeeForm() {
        binding.aEEMPIDReq.helperText = validEmail()
        binding.aEPhoneReq.helperText = validEmail()
        binding.aENameReq.helperText = validEmail()
        binding.aEDesignationReq.helperText = validEmail()
        binding.aERoleReq.helperText = validEmail()
        binding.aEEmailReq.helperText = validEmail()
        val validEmail = binding.aEEmailReq.helperText == null
        val validRoles = binding.aERoleReq.helperText == null
        val validEMPID = binding.aEEMPIDReq.helperText == null
        val validAEDesignation = binding.aEDesignationReq.helperText == null
        val validName = binding.aENameReq.helperText == null
        val validAPN = binding.aEPhoneReq.helperText == null
        if(validEmail  && validRoles && validEMPID && validAPN && validAEDesignation && validName)
            resetForm()
        else
            invalidForm()
    }
    private fun resetForm() {
            var message=""
            message += "\nEmail: " + binding.aEEmailEt.text
            message += "\nPhoneNumber: "+ binding.aEPhoneEt.text
            message += "\nEMPID: " + binding.aEEMPIDEt.text
            message += "\nname: "+ binding.aEnameEt.text
            message += "\nDesignation: " + binding.aEDesignationEt.text
            AlertDialog.Builder(this)
                .setTitle("employee added")
                .setMessage(message)
                .setPositiveButton("okay") { _, _ ->
                    binding.aEEmailEt.text = null
                    binding.aEPhoneEt.text = null
                    binding.aEEMPIDEt.text = null
                    binding.aEnameEt.text = null
                    binding.aEDesignationEt.text = null
                }
    }
    private fun invalidForm() {
        var message=" "
        if (binding.aEEmailReq.helperText != null)
            message += "\n\nEmail: " + binding.aEEmailReq.helperText
        if (binding.aENameReq.helperText != null)
            message += "\n\nEmpName: " + binding.aENameReq.helperText
        if (binding.aEDesignationReq.helperText != null)
            message += "\n\nDesignation: "+ binding.aEDesignationReq.helperText
        if (binding.aEEMPIDReq.helperText != null)
            message += "\n\nEMP-ID: " + binding.aEEMPIDReq.helperText
        if (binding.aEPhoneReq.helperText != null)
            message += "\n\nPhoneNumber: "+ binding.aEPhoneReq.helperText
        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay"){_,_->

            }

    }

    private fun aEmpIdFocusListener() {
        binding.aEEMPIDEt.setOnFocusChangeListener{_, focused->
            if (!focused)
            {
                binding.aEEMPIDReq.helperText=validEMPID()
            }
        }
    }
    private fun validEMPID(): String? {
        val empIDText=binding.aEPhoneEt.text.toString()
        if (empIDText.length != ConstantsValues.EMPIDVALUE)
        {
            return "EMP-ID must be 7 digits"
        }
        return null
    }
    private fun aphoneNumberFocusListener() {
        binding.aEPhoneEt.setOnFocusChangeListener{_, focused->
            if (!focused)
            {
                binding.aEPhoneReq.helperText=validAPN()
            }
        }
    }
    private fun validAPN(): String?
    {
        val aEmpPhoneNoText=binding.aEPhoneEt.text.toString()
        if (aEmpPhoneNoText.length !=ConstantsValues.phoneNumberValue)
        {
            return "PhoneNumber must be 10 digits"

        }
        else
            return null
    }
    private fun adesignationFocusListener() {
        binding.aEDesignationEt.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.aEDesignationReq.helperText=validAEDesignation()
            }
        }
    }
    private fun validAEDesignation(): String? {
        val aEDesignationText=binding.aEDesignationEt.text.toString()
        if(aEDesignationText.length != ConstantsValues.nameValue)

        {
            return "designation should not be empty"

        }
        return null
    }
    private fun aemailFocusListener() {
            binding.aEEmailEt.setOnFocusChangeListener { _, focused ->
                if (!focused) {
                    binding.aENameReq.helperText = validEmail()
                }
            }
    }
    private fun validEmail():String? {
        val aEmailText = binding.aEEmailEt.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(aEmailText).matches()) {
            return "Invalid EmailAdress"
        }
        return null
    }
    private fun anameFocusListener() {
        binding.aEnameEt.setOnFocusChangeListener { _, focused ->
            if (!focused)
            {
                binding.aENameReq.helperText = validName()
            }
        }
    }
    private fun validName(): String?{
        val anameText = binding.aEnameEt.text.toString()
        if(anameText.length <= nameValue) {
            return "name is required"
        }
            else
                return null

        }

    }
