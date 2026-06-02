package com.example.homesweethome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private lateinit var tvSubtotal: TextView
    private lateinit var tvGrandTotal: TextView
    private val deliveryCharge = AppData.DELIVERY_CHARGE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        container = findViewById(R.id.cartItemsContainer)
        tvSubtotal = findViewById(R.id.tvSubtotal)
        tvGrandTotal = findViewById(R.id.tvGrandTotal)

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<Button>(R.id.btnCheckout).setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("grand_total", calculateTotal() + deliveryCharge)
            startActivity(intent)
        }

        refreshCart()
    }

    private fun refreshCart() {
        container.removeAllViews()
        val inflater = LayoutInflater.from(this)

        AppData.cartItems.forEachIndexed { index, pair ->
            val product = pair.first
            var qty = pair.second

            val itemView = inflater.inflate(R.layout.item_cart, container, false)
            itemView.findViewById<TextView>(R.id.tvCartName).text = product.name
            itemView.findViewById<TextView>(R.id.tvCartDesc).text = product.description
            itemView.findViewById<TextView>(R.id.tvCartPrice).text = "$${String.format("%.2f", product.price)}"
            
            val tvQty = itemView.findViewById<TextView>(R.id.tvCartQty)
            tvQty.text = qty.toString()

            itemView.findViewById<TextView>(R.id.btnCartPlus).setOnClickListener {
                qty++
                AppData.cartItems[index] = product to qty
                tvQty.text = qty.toString()
                updateSummary()
            }

            itemView.findViewById<TextView>(R.id.btnCartMinus).setOnClickListener {
                if (qty > 1) {
                    qty--
                    AppData.cartItems[index] = product to qty
                    tvQty.text = qty.toString()
                    updateSummary()
                } else {
                    AppData.cartItems.removeAt(index)
                    refreshCart()
                }
            }
            container.addView(itemView)
        }
        updateSummary()
    }

    private fun calculateTotal(): Double {
        return AppData.cartItems.sumOf { it.first.price * it.second }
    }

    private fun updateSummary() {
        val sub = calculateTotal()
        tvSubtotal.text = "$${String.format("%.2f", sub)}"
        tvGrandTotal.text = "$${String.format("%.2f", sub + deliveryCharge)}"
    }
}
