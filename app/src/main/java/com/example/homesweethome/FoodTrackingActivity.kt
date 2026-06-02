package com.example.homesweethome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FoodTrackingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_tracking)

        val userName = AppData.userName

        // Set Current Date for Tracking Status
        val sdf = SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.US)
        findViewById<TextView>(R.id.tvTrackingStatusDate).text = sdf.format(Date())

        // Dynamic Status Updates
        val tvStatus1 = findViewById<TextView>(R.id.tvStatus1)
        val tvStatusDesc1 = findViewById<TextView>(R.id.tvStatusDesc1)
        val tvStatus2 = findViewById<TextView>(R.id.tvStatus2)
        val tvStatusDesc2 = findViewById<TextView>(R.id.tvStatusDesc2)
        val tvStatus3 = findViewById<TextView>(R.id.tvStatus3)
        val tvStatusDesc3 = findViewById<TextView>(R.id.tvStatusDesc3)

        tvStatus1.text = "Order Placed"
        tvStatusDesc1.text = "We have received $userName order"
        
        tvStatus2.text = "Packing Product"
        tvStatusDesc2.text = "Dealer paying $userName order"
        
        tvStatus3.text = "Out for Delivery"
        tvStatusDesc3.text = "Delivery pattern looking for $userName"

        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        findViewById<CardView>(R.id.btnCall).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9600764319")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnChatWithDriver).setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        findViewById<CardView>(R.id.btnChat).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:support@homesweethome.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Order Support - Home Sweet Home")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnReceived).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Order Received")
                .setMessage("Have you received your order?")
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "Thank you! Visit again.", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}
