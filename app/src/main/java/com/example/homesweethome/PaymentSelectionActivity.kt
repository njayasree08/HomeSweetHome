package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaymentSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_selection)

        val grandTotal = intent.getDoubleExtra("grand_total", 0.0)
        val address = intent.getStringExtra("delivery_address") ?: ""

        val rg = findViewById<RadioGroup>(R.id.rgPayment)
        val btnConfirm = findViewById<Button>(R.id.btnConfirmOrder)

        btnConfirm.setOnClickListener {
            val selectedId = rg.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rb = findViewById<RadioButton>(selectedId)
            val method = rb.text.toString()

            val intent = Intent(this, PaymentSummaryActivity::class.java)
            intent.putExtra("grand_total", grandTotal)
            intent.putExtra("delivery_address", address)
            intent.putExtra("payment_method", method)
            startActivity(intent)
        }
    }
}
