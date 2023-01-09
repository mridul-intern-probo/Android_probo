package com.probo.registration_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {

//    lateinit var button: Button
//    lateinit var emailId: EditText
//    var emailPattern = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val button = findViewById<Button>(R.id.go_home)
        button.setOnClickListener{
            val intent = Intent(this,   Homepage::class.java)
            startActivity(intent)
        }

//        button = findViewById(R.id.go_home)
//        emailId = findViewById(R.id.email)

//        button.setOnClickListener {
//            if (emailId.text.toString().isEmpty()) {
//                Toast.makeText(applicationContext, "enter email address", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                if (emailId.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())) {
//                    Toast.makeText(applicationContext, "valid email address", Toast.LENGTH_SHORT).show()
//                }
//                else {
//                    Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }
}