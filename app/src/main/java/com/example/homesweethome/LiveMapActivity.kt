package com.example.homesweethome

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LiveMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_map)

        findViewById<ImageView>(R.id.btnBackMap).setOnClickListener {
            finish()
        }
    }
}
