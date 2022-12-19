package com.example.inventory
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.Spinner
import androidx.appcompat.R
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.ConstantsValues.Companion.designationValue
import com.example.inventory.ConstantsValues.Companion.nameValue
import com.example.inventory.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        nameFocusListener()
        designationFocusListener()
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

               val items = ArrayList<String>()

        val list: MutableList<String> = ArrayList()

//        for (i: Int in 1..2)
           list.add("")
        list.add("admin")
        list.add("employee")
        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item, list
        )
        spnTest1.adapter = adapter
        spnTest1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item:String=list[position]
              //  Toast.makeText(this@SignUp,"$item selected",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        limitDropDownHeight(spnTest1)

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
                binding.dReq.helperText=validDesignation()
            }

        }
    }
    private fun validDesignation(): String?
    {
        val designationText = binding.designationEt.text.toString()
        if(designationText.length <= designationValue)
        {
            return "designation is required"
        }
        return null
    }
    private fun signUpForm() {
        binding.emailReq.helperText = validEmail()
        binding.pReq.helperText = validPhoneNumber()
        binding.dReq.helperText = validDesignation()
        binding.nameReq.helperText=validname()
        val validEmail = binding.emailReq.helperText == null
        val validName = binding.nameReq.helperText == null
        val validDesignation = binding.dReq.helperText == null
        val validPhoneNumber = binding.pReq.helperText == null
        if(validEmail  && validPhoneNumber && validDesignation && validName)
addDummyUserSu()
        else {
            invalidForm()
        }
    }

    private fun invalidForm() {
        var message=" "
        if (binding.emailReq.helperText != null)
            message += "\n\nEmail: " + binding.emailReq.helperText
        if (binding.pReq.helperText != null)
            message += "\n\nPhoneNumber: "+ binding.pReq.helperText
        if (binding.dReq.helperText != null)
            message += "\n\nDesignation: " + binding.dReq.helperText
        if (binding.nameReq.helperText != null)
            message += "\n\nName: " + binding.nameReq.helperText


        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay"){_,_->

            }
    }

//    private fun resetForm() {
//        var message=" "
//        message += "\nEmail: " + binding.emailEditText.text
//        message += "\nPhoneNumber: "+ binding.phoneNumberEditText.text
//        message += "\nDesignation: "+ binding.designationEt.text
//        message += "\nName: "+ binding.nameEt.text
//        AlertDialog.Builder(this)
//            .setTitle(" signup completed")
//            .setMessage(message)
//            .setPositiveButton("okay") { _, _ ->
//                binding.emailEditText.text = null
//                binding.nameEt.text = null
//                binding.designationEt.text = null
//                binding.phoneNumberEditText.text = null
//            }
//    }
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
        if(phoneNumberText.length != 10)

        {
            return "Must be 10 digits"

        }
        return null
    }
    private fun limitDropDownHeight(spnTest1: Spinner) {

        val popup: java.lang.reflect.Field = Spinner::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val popupWindow: ListPopupWindow = popup.get(spnTest1) as ListPopupWindow
        popupWindow.height = (200 * resources.displayMetrics.density).toInt()
    }
    fun addDummyUserSu()
    {
        val apiServices=RestApiService()
            val empSignUpRequest = EmpSignUpRequest(
                 nameEt.text.toString() ,
                phoneNumberEditText.text.toString(),
                emailEditText.text.toString(),
                designationEt.text.toString(),
                false,
                arrayOf(spnTest1)
            )
            apiServices.addUserSignUp(empSignUpRequest)
            val intent=Intent(this@SignUp,MainActivity::class.java)
                startActivity(intent)
            }

        }


