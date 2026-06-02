package com.example.homesweethome

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RestaurantListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        val tvTitle = findViewById<TextView>(R.id.tvHomeSweetListTitle)
        tvTitle.text = "HOMESWEET CATEGORIES"

        val container = findViewById<LinearLayout>(R.id.homeSweetContainer)
        val categories = listOf("Laundry", "Kitchen", "Bathroom", "Cleaning Supplies", "Home Maintenance", "Lighting", "Power & Safety")

        categories.forEach { name ->
            val textView = TextView(this).apply {
                text = name
                textSize = 18f
                setPadding(32, 32, 32, 32)
                setBackgroundResource(android.R.drawable.editbox_background_normal)
            }
            container.addView(textView)
        }
    }
}
