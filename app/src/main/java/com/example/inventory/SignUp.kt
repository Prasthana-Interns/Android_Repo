package com.example.inventory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.R
import androidx.appcompat.app.AlertDialog
import com.example.inventory.ConstantsValues.Companion.designationValue
import com.example.inventory.ConstantsValues.Companion.nameValue
import com.example.inventory.ConstantsValues.Companion.phoneNumberValue
import com.example.inventory.ConstantsValues.Companion.spinnerHeightValue
import com.example.inventory.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.reflect.Field

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        phoneNumberFocusListener()
        binding.signUpButton.setOnClickListener {
            signUpForm()
        }
        backToLogin2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        loginHere.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val list: MutableList<String> = ArrayList()

        list.add("admin")
        list.add("employee")
        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, list
        )
        spnTest.adapter = adapter
        spnTest.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item:String=list[position]
                Toast.makeText(this@SignUp,"$item selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        limitDropDownHeight(spnTest)

    }
    private fun nameFocusListener()
    {
        binding.nameEt.setOnFocusChangeListener{_, focused->
            if(!focused)
            {
                binding.nameReq.helperText=validname()
            }

        }
    }

    private fun validname(): String?
    {
        val nameText = binding.nameEt.text.toString()
        if(nameText.length <= nameValue)
        {
            return "name is required"
        }
        return null


    }
  private fun designationFocusListener()
    {
        binding.designationEt.setOnFocusChangeListener{_, focused->
            if(!focused)
            {
                binding.nameReq.helperText=validdesignation()
            }

        }
    }

    private fun validdesignation(): String?
    {
        val designationText = binding.nameEt.text.toString()
        if(designationText.length <= designationValue)
        {
            return "designation is required"
        }
        return null


    }
    private fun signUpForm() {
        binding.emailReq.helperText = validEmail()
        binding.pReq.helperText = validPhoneNumber()
        val validEmail = binding.emailReq.helperText == null
        val validPhoneNumber = binding.pReq.helperText == null
        if(validEmail  && validPhoneNumber)
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        var message=" "
        if (binding.emailReq.helperText != null)
            message += "\n\nEmail: " + binding.emailReq.helperText
        if (binding.pReq.helperText != null)
            message += "\n\nPhoneNumber: "+ binding.pReq.helperText
        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay"){_,_->

            }
    }

    private fun resetForm() {
        var message=" "
        message += "\nEmail: " + binding.emailEditText.text
        message += "\nPhoneNumber: "+ binding.phoneNumberEditText.text
        AlertDialog.Builder(this)
            .setTitle(" signup completed")
            .setMessage(message)
            .setPositiveButton("okay") { _, _ ->
                binding.emailEditText.text = null
                binding.phoneNumberEditText.text = null


            }

    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailReq.helperText=validEmail()
            }
        }
    }

    private fun validEmail(): String?
    {
        val emailText=binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid EmailAdress"

        }
        return null
    }
    private fun phoneNumberFocusListener() {
        binding.phoneNumberEditText.setOnFocusChangeListener { _, focused ->
            if(!focused)
            {
                binding.emailReq.helperText=validPhoneNumber()
            }
        }
    }

    private fun validPhoneNumber(): String?
    {
        val phoneNumberText=binding.phoneNumberEditText.text.toString()
        if(phoneNumberText.length != phoneNumberValue)

        {
            return "Must be 10 digits"

        }
        return null
    }
    private fun limitDropDownHeight(spnTest: Spinner) {

        val popup: Field = Spinner::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val popupWindow: ListPopupWindow = popup.get(spnTest) as ListPopupWindow
        popupWindow.height = (spinnerHeightValue * resources.displayMetrics.density).toInt()
    }

}
