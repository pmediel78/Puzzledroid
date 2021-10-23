package com.example.puzzledroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest

class AyudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        val myWebView = findViewById<WebView>(R.id.myWebView)
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?): Boolean {
                return false
            }
        }
        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://sites.google.com/d/1jjFHKPbHNH138Rr8hejCFTuhB6t2wmot/p/183uUWn-F7nmc2yBGNhkYLktK3X8mz7yS/edit")
    }
}