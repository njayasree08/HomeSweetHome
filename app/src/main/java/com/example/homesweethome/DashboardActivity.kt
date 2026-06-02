package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvWelcomeUser = findViewById<TextView>(R.id.tvWelcomeUser)
        tvWelcomeUser.text = "HOMESWEETHOME WELCOMES'S YOU ${AppData.userName.uppercase()}"

        findViewById<CardView>(R.id.btnViewHomeSweet).setOnClickListener {
            startActivity(Intent(this, HomeListActivity::class.java))
        }

        findViewById<CardView>(R.id.btnViewCart).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        setupRecommendations()
    }

    private fun setupRecommendations() {
        val container = findViewById<LinearLayout>(R.id.recommendationsContainer)
        container.removeAllViews()
        val inflater = LayoutInflater.from(this)

        val recommendations = AppData.homeProducts.take(5)

        recommendations.forEach { product ->
            val itemView = inflater.inflate(R.layout.item_recommended_food, container, false)
            
            val tvName = itemView.findViewById<TextView>(R.id.tvFoodName)
            val tvDesc = itemView.findViewById<TextView>(R.id.tvDescription)
            val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
            val tvQuantity = itemView.findViewById<TextView>(R.id.tvQuantity)
            val btnMinus = itemView.findViewById<TextView>(R.id.btnMinus)
            val btnPlus = itemView.findViewById<TextView>(R.id.btnPlus)
            val btnAdd = itemView.findViewById<Button>(R.id.btnAddToCart)
            
            tvName.text = product.name
            tvDesc.text = product.description
            tvPrice.text = "$${String.format("%.2f", product.price)}"
            
            var quantity = 1
            
            fun updateUI() {
                tvQuantity.text = quantity.toString()
                tvPrice.text = "$${String.format("%.2f", product.price * quantity)}"
            }

            btnPlus.setOnClickListener {
                quantity++
                updateUI()
            }

            btnMinus.setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    updateUI()
                }
            }

            btnAdd.setOnClickListener {
                AppData.addToCart(product, quantity)
                Toast.makeText(this, "${product.name} added to cart!", Toast.LENGTH_SHORT).show()
            }

            itemView.setOnClickListener {
                val intent = Intent(this, FoodDetailActivity::class.java)
                intent.putExtra("home_product", product)
                startActivity(intent)
            }

            updateUI()
            container.addView(itemView)
        }
    }
}
