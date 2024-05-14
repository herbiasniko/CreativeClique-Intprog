package com.ucb.creativeclique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AccountRegistered : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_registered)

        val fullNameTxtView = findViewById<TextView>(R.id.text_1)
        val emailOrPhoneTxtView = findViewById<TextView>(R.id.text_2)
        val passwordTxtView = findViewById<TextView>(R.id.text_3)

        val fullName = intent.getStringExtra("Full Name")
        val emailOrPhone = intent.getStringExtra("Email Or Phone Number")
        val password = intent.getStringExtra("Password")

        fullNameTxtView.text = "Full Name: $fullName"
        emailOrPhoneTxtView.text = "Email/Phone: $emailOrPhone"
        passwordTxtView.text = "Password: $password"

        val continueBtn = findViewById<Button>(R.id.btn1)

        continueBtn.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }
    }
}