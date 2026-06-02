package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OtpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification)

        val etOtp = findViewById<EditText>(R.id.etOtp)
        val btnVerify = findViewById<Button>(R.id.btnVerify)
        val tvResend = findViewById<TextView>(R.id.tvResend)

        var currentOtp = "2468"

        btnVerify.setOnClickListener {
            val otp = etOtp.text.toString().trim()
            if (otp == currentOtp) {
                Toast.makeText(this, "Verification Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
            }
        }

        tvResend.setOnClickListener {
            currentOtp = "1357"
            Toast.makeText(this, "New OTP sent: 1357", Toast.LENGTH_SHORT).show()
        }
    }
}
