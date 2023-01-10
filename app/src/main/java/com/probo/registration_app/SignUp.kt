package com.probo.registration_app

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import java.util.regex.Pattern
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDate
import java.time.Period
import java.util.*

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding;

    private fun isValidEmail(email:String):Boolean{
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun isValidPassword(password:String):Boolean{
        return Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$").matcher(password).matches();
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun is18yearold(day: Int, month: Int, year: Int):Int{
        var age = Period.between(LocalDate.of(year, month+1, day), LocalDate.now()).years;
        return age
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signInBtn = findViewById<Button>(R.id.go_home)

        val email = findViewById<AppCompatEditText>(R.id.email)
//        val dateofbirth = findViewById<AppCompatEditText>(R.id.dob)
        val password = findViewById<AppCompatEditText>(R.id.password)
        val confirmpass = findViewById<AppCompatEditText>(R.id.confirm_password)
        var m_month = 0
        var m_day = 0
        var m_year = 0

//        val date = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
//        val month = Calendar.getInstance().get(Calendar.MONTH)
//        val year = Calendar.getInstance().get(Calendar.YEAR)

//        Log.d(TAG, "onCreate: " + date + month + year);
        val datePicker = findViewById<DatePicker>(R.id.date_Picker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            m_month = month + 1
            m_day = day
            m_year = year
//            val msg = "You Selected: $day/$month/$year"
//            Toast.makeText(this@SignUp, msg, Toast.LENGTH_SHORT).show()
        }

        signInBtn.setOnClickListener {
            val email1= email.text.toString()
//            val dob  = dateofbirth.text.toString()
            val pass = password.text.toString()
            val c_pass = confirmpass.text.toString()

            if (email1.isEmpty() || pass.isEmpty() || c_pass.isEmpty()) {
                Toast.makeText(
                    getApplicationContext(),
                    "Please fill all the fields!",
                    Toast.LENGTH_SHORT
                ).show();
            } else if (!isValidEmail(email1)){
                Toast.makeText(
                    getApplicationContext(),
                    "Please enter valid email",
                    Toast.LENGTH_SHORT).show()
            }else if(!isValidPassword(pass)){
                Toast.makeText(
                getApplicationContext(),
                "Password must contain atleast one Capital Letter, one Small Letter, one Number" +", one symbol and should be atleast 8 characters long",
                Toast.LENGTH_SHORT).show()
            }else if(is18yearold(m_day,m_month,m_year)<18){
                Toast.makeText(
                    getApplicationContext(),
                    "email"+email1,
                    Toast.LENGTH_SHORT).show()
            }else if(!pass.equals(c_pass)) {
                Toast.makeText(
                    getApplicationContext(),
                    "Password and Confirm Password must be the same!",
                    Toast.LENGTH_SHORT
                ).show();
            }else{signInBtn.setOnClickListener {

                val intent=Intent(SignUp@this,Homepage::class.java)
                val bundle=Bundle()
                bundle.putString("email",email1)
                bundle.putString("password",pass)
                bundle.putString("confirm",c_pass)
                bundle.putString("dob",""+m_day+"/"+m_month+"/"+m_year)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
                }
            }
        }
    }
}

class ActivitySecondBinding {

}
