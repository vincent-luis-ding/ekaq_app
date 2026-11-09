package com.ekaq.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
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
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            setBackgroundColor(Color.WHITE)
        }
        setContentView(webView)

        webView.loadDataWithBaseURL(
            null,
            "<html><body style='background:#fff;color:#000;padding:40px;'><h1>Hello EKAQ</h1><p>WebView rendering test</p></body></html>",
            "text/html",
            "utf-8",
            null
        )
    }
}
