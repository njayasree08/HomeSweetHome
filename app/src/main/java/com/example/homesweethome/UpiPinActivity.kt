package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UpiPinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upi_pin)

        val total = intent.getDoubleExtra("grand_total", 0.0)
        val expectedLength = intent.getIntExtra("pin_length", 6)

        findViewById<TextView>(R.id.tvAmountUpi).text = "$${String.format("%.2f", total)}"
        val label = findViewById<TextView>(R.id.tvEnterPinLabel)
        label.text = "ENTER $expectedLength-DIGIT UPI PIN"

        val etPin = findViewById<EditText>(R.id.etUpiPin)
        etPin.maxLength(expectedLength)

        val correctPin = if (expectedLength == 4) AppData.UPI_PIN_4 else AppData.UPI_PIN_6

        findViewById<ImageView>(R.id.btnSubmitUpi).setOnClickListener {
            val pin = etPin.text.toString()
            if (pin == correctPin) {
                val intent = Intent(this, PaymentSuccessfulActivity::class.java)
                intent.putExtra("amount_paid", total)
                intent.putExtra("payment_method", "UPI")
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect PIN. Use $correctPin", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun EditText.maxLength(length: Int) {
        filters = arrayOf(android.text.InputFilter.LengthFilter(length))
    }
}
