package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class PaymentSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_summary)

        val total = intent.getDoubleExtra("grand_total", 0.0)
        val method = intent.getStringExtra("payment_method") ?: "UPI Payment"

        findViewById<TextView>(R.id.tvPaymentGrandTotal).text = "$${String.format("%.2f", total)}"
        findViewById<TextView>(R.id.tvPayingVia).text = "Paying via $method"

        findViewById<CardView>(R.id.cardUpi4).setOnClickListener {
            val intent = Intent(this, UpiPinActivity::class.java)
            intent.putExtra("grand_total", total)
            intent.putExtra("pin_length", 4)
            startActivity(intent)
            finish()
        }

        findViewById<CardView>(R.id.cardUpi6).setOnClickListener {
            val intent = Intent(this, UpiPinActivity::class.java)
            intent.putExtra("grand_total", total)
            intent.putExtra("pin_length", 6)
            startActivity(intent)
            finish()
        }
    }
}
