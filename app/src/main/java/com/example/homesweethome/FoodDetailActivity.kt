package com.example.homesweethome

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FoodDetailActivity : AppCompatActivity() {
    
    private var quantity = 1
    private lateinit var homeProduct: HomeProduct

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        homeProduct = intent.getSerializableExtra("home_product") as HomeProduct

        val ivProduct = findViewById<ImageView>(R.id.ivFoodLarge)
        val tvName = findViewById<TextView>(R.id.tvFoodNameDetail)
        val tvBrand = findViewById<TextView>(R.id.tvHomeSweetDetail)
        val tvRating = findViewById<TextView>(R.id.tvRatingDetail)
        val tvDescription = findViewById<TextView>(R.id.tvDescriptionDetail)
        val tvPrice = findViewById<TextView>(R.id.tvPriceDetail)
        val tvQuantity = findViewById<TextView>(R.id.tvQuantityDetail)
        
        val btnPlus = findViewById<TextView>(R.id.btnPlusDetail)
        val btnMinus = findViewById<TextView>(R.id.btnMinusDetail)
        val btnAddToCart = findViewById<Button>(R.id.btnAddToCartDetail)
        val btnBack = findViewById<ImageView>(R.id.btnBackDetail)

        ivProduct.setImageResource(homeProduct.imageRes)
        tvName.text = homeProduct.name
        tvBrand.text = homeProduct.description
        tvRating.text = homeProduct.rating.toString()
        tvDescription.text = homeProduct.longDescription
        
        fun updateUI() {
            tvPrice.text = "$${String.format("%.2f", homeProduct.price * quantity)}"
            tvQuantity.text = quantity.toString()
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

        btnAddToCart.setOnClickListener {
            AppData.addToCart(homeProduct, quantity)
            Toast.makeText(this, "${homeProduct.name} added to cart!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnBack.setOnClickListener {
            finish()
        }

        updateUI()
    }
}
