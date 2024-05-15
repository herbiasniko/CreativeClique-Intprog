package com.ucb.creativeclique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerBtn = findViewById<ImageButton>(R.id.btn1)

        registerBtn.setOnClickListener {
            val fullName = findViewById<EditText>(R.id.editxt_1).text.toString()
            val email = findViewById<EditText>(R.id.editxt_2).text.toString()
            val password = findViewById<EditText>(R.id.editxt_3).text.toString()

            if (isValidEmail(email) && isValidPassword(password)) {
                if (AccountManager.Search(email)) {
                    Toast.makeText(this, "Email address is already registered", Toast.LENGTH_SHORT).show()
                } else {
                    val newAccount = AccountDetails(fullName, email, password)
                    AccountManager.register(newAccount)

                    val intent = Intent(this, Signin::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                if (!isValidEmail(email)) {
                    Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Password must have at least 8 characters and 1 special character.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        var text_5 = findViewById<TextView>(R.id.text_5)
        text_5.setOnClickListener {
            var intent = Intent(this, Signin::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return emailPattern.matches(email)
    }

    private fun isValidPassword(password: String): Boolean {
        val pattern = Regex("^(?=.*[\\W_])(?=.*[a-zA-Z0-9]).{8,}\$")
        return pattern.matches(password)
    }


}