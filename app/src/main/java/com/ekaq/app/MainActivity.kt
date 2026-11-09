package com.ekaq.app

import android.os.Bundle
import android.widget.TextView
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "EKAQ Test\nIf you see this, the app works."
        tv.setTextColor(Color.WHITE)
        tv.textSize = 20f
        tv.setPadding(40, 120, 40, 40)
        tv.setBackgroundColor(Color.parseColor("#0B111E"))
        setContentView(tv)
    }
}
