package com.xx.filemanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_pic).setOnClickListener(View.OnClickListener { view ->
            startActivity(Intent(this, PicFileActivity::class.java))
        }
        )
        findViewById<TextView>(R.id.tv_office).setOnClickListener(View.OnClickListener { view ->
            startActivity(Intent(this, OfficeFileActivity::class.java))
        }
        )
    }
}