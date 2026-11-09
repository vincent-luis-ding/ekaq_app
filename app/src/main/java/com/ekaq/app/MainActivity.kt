package com.ekaq.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
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
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    val msg = "Error: ${error?.description} (code: ${error?.errorCode})"
                    view?.loadDataWithBaseURL(
                        null,
                        "<html><body style='background:#0B111E;color:#fff;padding:40px;font-family:sans-serif;'><h2>EKAQ</h2><p>$msg</p></body></html>",
                        "text/html", "utf-8", null
                    )
                }
            }
            webChromeClient = WebChromeClient()
            setBackgroundColor(Color.parseColor("#0B111E"))
        }
        setContentView(webView)

        webView.loadUrl("https://ekaq.com")
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
