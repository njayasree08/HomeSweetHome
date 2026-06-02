package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PaymentSuccessfulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_successful)

        val amount = intent.getDoubleExtra("amount_paid", 0.0)
        val method = intent.getStringExtra("payment_method") ?: "UPI"

        findViewById<TextView>(R.id.tvAmountPaid).text = "$${String.format("%.2f", amount)}"
        findViewById<TextView>(R.id.tvMethod).text = method
        
        val timeSdf = SimpleDateFormat("hh:mm a", Locale.US)
        val dateSdf = SimpleDateFormat("MMM dd, yyyy", Locale.US)
        findViewById<TextView>(R.id.tvTime).text = timeSdf.format(Date())
        findViewById<TextView>(R.id.tvDate).text = dateSdf.format(Date())

        findViewById<Button>(R.id.btnTrackOrder).setOnClickListener {
            val intent = Intent(this, FoodTrackingActivity::class.java)
            startActivity(intent)
            AppData.cartItems.clear()
            finish()
        }
    }
}
