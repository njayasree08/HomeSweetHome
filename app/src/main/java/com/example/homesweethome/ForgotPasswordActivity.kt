package com.example.homesweethome

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val etEmail = findViewById<EditText>(R.id.etEmailReset)
        val etNewPass = findViewById<EditText>(R.id.etNewPassword)
        val btnUpdate = findViewById<Button>(R.id.btnUpdatePassword)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnUpdate.setOnClickListener {
            val email = etEmail.text.toString()
            val newPass = etNewPass.text.toString()

            if (email == AppData.FIXED_EMAIL && newPass.isNotEmpty()) {
                Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
