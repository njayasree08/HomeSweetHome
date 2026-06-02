package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_list)

        val container = findViewById<LinearLayout>(R.id.homeSweetContainer)
        val inflater = LayoutInflater.from(this)

        AppData.homeProducts.forEach { product ->
            val itemView = inflater.inflate(R.layout.item_recommended_food, container, false)
            
            itemView.findViewById<TextView>(R.id.tvFoodName).text = product.name
            itemView.findViewById<TextView>(R.id.tvDescription).text = product.description
            val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
            tvPrice.text = "$${String.format("%.2f", product.price)}"
            
            val tvQty = itemView.findViewById<TextView>(R.id.tvQuantity)
            var quantity = 1

            itemView.findViewById<TextView>(R.id.btnPlus).setOnClickListener {
                quantity++
                tvQty.text = quantity.toString()
                tvPrice.text = "$${String.format("%.2f", product.price * quantity)}"
            }

            itemView.findViewById<TextView>(R.id.btnMinus).setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    tvQty.text = quantity.toString()
                    tvPrice.text = "$${String.format("%.2f", product.price * quantity)}"
                }
            }

            itemView.findViewById<Button>(R.id.btnAddToCart).setOnClickListener {
                AppData.addToCart(product, quantity)
                Toast.makeText(this, "${product.name} added to cart!", Toast.LENGTH_SHORT).show()
            }

            itemView.setOnClickListener {
                val intent = Intent(this, FoodDetailActivity::class.java)
                intent.putExtra("home_product", product)
                startActivity(intent)
            }

            container.addView(itemView)
        }
    }
}
