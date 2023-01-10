package com.probo.registration_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text


class Homepage : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        var email = findViewById<TextView>(R.id.email)
        var date = findViewById<TextView>(R.id.dob)
        var pass = findViewById<TextView>(R.id.password)
        var bundle = intent.extras
        if(bundle!=null){
            email.text= bundle.getString("email")
            date.text= bundle.getString("dob")
            pass.text= bundle.getString("password")

        }

        button = findViewById(R.id.show_img_btn)
        imageView = findViewById(R.id.img_view)

        button.setOnClickListener{
            pickImageGallery()
        }

    }

    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== IMAGE_REQUEST_CODE && resultCode== RESULT_OK){
            imageView.setImageURI(data?.data)
        }

    }
}