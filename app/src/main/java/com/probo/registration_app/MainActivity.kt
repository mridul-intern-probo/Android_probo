package com.probo.registration_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        getWindow().setFlags(WindowManger.LayoutParams.FLAG_FULLSCREEN,WindowManger.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}