package com.ekaq.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            setBackgroundColor(Color.parseColor("#0B111E"))
        }
        setContentView(webView)

        // First test: load built-in page
        webView.loadData(
            "<html><body style='background:#0B111E;color:#fff;padding:40px;font-family:sans-serif;'><h1>WebView OK</h1><p>If you see this, WebView works. Now loading ekaq.com...</p></body></html>",
            "text/html",
            "utf-8"
        )

        // Then load the real site after 2 seconds
        webView.postDelayed({
            webView.loadUrl("https://ekaq.com")
        }, 2000)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
