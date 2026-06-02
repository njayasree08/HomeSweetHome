package com.example.homesweethome

import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ChatActivity : AppCompatActivity() {
    private lateinit var chatContainer: LinearLayout
    private lateinit var etMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        chatContainer = findViewById(R.id.chatContainer)
        etMessage = findViewById(R.id.etMessage)
        val btnSend = findViewById<ImageButton>(R.id.btnSend)

        // Initial message
        addMessage("Hello! I'm Robert, your delivery partner.", false)

        btnSend.setOnClickListener {
            val msg = etMessage.text.toString().trim()
            if (msg.isNotEmpty()) {
                addMessage(msg, true)
                etMessage.text.clear()
                handleResponse(msg)
            }
        }
    }

    private fun addMessage(text: String, isMe: Boolean) {
        val textView = TextView(this).apply {
            this.text = text
            setPadding(32, 16, 32, 16)
            textSize = 16f
            setTextColor(if (isMe) ContextCompat.getColor(context, R.color.white) else ContextCompat.getColor(context, R.color.black))
            background = if (isMe) {
                ContextCompat.getDrawable(context, R.drawable.bg_bubble_me)
            } else {
                ContextCompat.getDrawable(context, R.drawable.bg_bubble_other)
            }
        }

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = if (isMe) Gravity.END else Gravity.START
            topMargin = 16
        }

        chatContainer.addView(textView, params)
        // Scroll to bottom
        findViewById<android.widget.ScrollView>(R.id.chatScrollView).post {
            findViewById<android.widget.ScrollView>(R.id.chatScrollView).fullScroll(android.widget.ScrollView.FOCUS_DOWN)
        }
    }

    private fun handleResponse(userMsg: String) {
        val lowerMsg = userMsg.lowercase()
        val response = when {
            lowerMsg.contains("hi") || lowerMsg.contains("hello") || lowerMsg.contains("hey") -> 
                "Hello ${AppData.userName}! I'm on my way to your location."
            
            lowerMsg.contains("where") || lowerMsg.contains("location") -> 
                "I'm currently at Paruthipattu, just a few minutes away from Avadi."
            
            lowerMsg.contains("time") || lowerMsg.contains("long") || lowerMsg.contains("when") -> 
                "I'll reach your doorstep in approximately 10-15 minutes."
            
            lowerMsg.contains("delay") || lowerMsg.contains("late") || lowerMsg.contains("slow") -> 
                "Apologies for the delay! There is a bit of traffic near Phase 3, but I'm moving now."
            
            lowerMsg.contains("product") || lowerMsg.contains("item") || lowerMsg.contains("safety") -> 
                "I have all your home products safely packed in the delivery box."
            
            lowerMsg.contains("call") || lowerMsg.contains("phone") -> 
                "You can reach me at 9600764319 if you need more details!"
            
            lowerMsg.contains("thanks") || lowerMsg.contains("thank you") -> 
                "You're welcome! Happy to help."
            
            lowerMsg.contains("ok") || lowerMsg.contains("sure") || lowerMsg.contains("fine") -> 
                "Great! See you soon."
            
            else -> "Got it! I'm focused on getting your order to you safely."
        }
        
        chatContainer.postDelayed({
            addMessage(response, false)
        }, 1500) // 1.5s delay for realistic feel
    }
}
