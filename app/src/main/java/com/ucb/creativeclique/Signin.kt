package com.ucb.creativeclique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val emailOrPhoneEdTxt = findViewById<EditText>(R.id.editxt_1)
        val passwordEdTxt = findViewById<EditText>(R.id.editxt_2)
        val forgotPassTxtView = findViewById<TextView>(R.id.text_2)
        val registerTxtView = findViewById<TextView>(R.id.text_6)
        val signinBtn = findViewById<ImageButton>(R.id.btn1)

        forgotPassTxtView.setOnClickListener{
            val intent = Intent(this, ForgotPassword::class.java)
            intent.putExtra("Email or Phone Number", emailOrPhoneEdTxt.text.toString())
            intent.putExtra("Password", emailOrPhoneEdTxt.text.toString())
            startActivity(intent)
        }
        registerTxtView.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }

        signinBtn.setOnClickListener {
            val username = emailOrPhoneEdTxt.text.toString()
            val password = passwordEdTxt.text.toString()

            val logIn = AccountManager.logIn(username, password)

            if(logIn){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}