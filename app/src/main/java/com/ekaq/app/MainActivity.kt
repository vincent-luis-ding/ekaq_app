package com.ekaq.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            setBackgroundColor(Color.WHITE)
        }
        setContentView(webView)

        // White background + test text
        webView.loadData(
            "<html><body style='background:#fff;color:#000;padding:40px;font-family:sans-serif;'><h1>WebView Test</h1><p>If you see this on white background, WebView works!</p></body></html>",
            "text/html",
            "utf-8"
        )
    }
}
