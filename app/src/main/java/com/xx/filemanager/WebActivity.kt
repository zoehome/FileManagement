package com.xx.filemanager

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val wv:WebView=findViewById(R.id.wv_office)
        val set:WebSettings=wv.settings
        set.javaScriptEnabled=true
        var url:String="https://view.officeapps.live.com/op/view.aspx?src="+ intent.getStringExtra("path");
        wv.loadUrl(url)
//        intent.getStringExtra("path")?.let { wv.loadUrl("https://view.officeapps.live.com/op/view.aspx?src="+it) }

    }
}