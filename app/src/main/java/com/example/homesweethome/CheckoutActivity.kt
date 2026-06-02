package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val grandTotal = intent.getDoubleExtra("grand_total", 0.0)

        val etName = findViewById<EditText>(R.id.etFullName)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val btnProceed = findViewById<Button>(R.id.btnProceedPayment)
        val btnBack = findViewById<ImageButton>(R.id.btnBackCheckout)

        // Spinners
        val spinnerGender = findViewById<Spinner>(R.id.spinnerGender)
        val genders = arrayOf("MALE", "FEMALE")
        spinnerGender.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)

        val spinnerState = findViewById<Spinner>(R.id.spinnerState)
        val states = arrayOf("Tamil Nadu", "Karnataka", "Kerala")
        spinnerState.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, states)

        val spinnerCity = findViewById<Spinner>(R.id.spinnerCity)
        val cities = arrayOf("Chennai", "Bangalore", "Kochi")
        spinnerCity.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)

        btnBack.setOnClickListener { finish() }

        btnProceed.setOnClickListener {
            val name = etName.text.toString().trim()
            val addr = etAddress.text.toString().trim()

            if (name.isNotEmpty() && addr.isNotEmpty()) {
                val intent = Intent(this, PaymentSelectionActivity::class.java)
                intent.putExtra("grand_total", grandTotal)
                intent.putExtra("delivery_address", addr)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill required details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
