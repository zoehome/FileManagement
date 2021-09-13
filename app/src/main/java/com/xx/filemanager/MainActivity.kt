package com.xx.filemanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.ValueCallback
import com.xx.Filelibrary.callback.FileCallBack
import com.xx.Filelibrary.ui.activity.OfficeFileActivity
import com.xx.Filelibrary.ui.activity.PicFileActivity
import com.xx.Filelibrary.ui.dialog.FileTypeDialog
import com.xx.Filelibrary.util.FMSaticValue.FM_FILE
import com.xx.Filelibrary.util.FMSaticValue.FM_IMAGE

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_pic).setOnClickListener(View.OnClickListener { view ->
            startActivityForResult(Intent(this, PicFileActivity::class.java), FM_IMAGE)
        }
        )
        findViewById<TextView>(R.id.tv_office).setOnClickListener(View.OnClickListener { view ->
            startActivityForResult(Intent(this, OfficeFileActivity::class.java),FM_FILE)
        }
        )
        findViewById<TextView>(R.id.tv_dialog).setOnClickListener(View.OnClickListener { view-> val dialog:FileTypeDialog=FileTypeDialog(this,
            FileCallBack { files ->

                val params:HashMap<String, String>  =  HashMap<String, String>();
                params.put("style", "1");
                params.put("local", "true");
                QbSdk.openFileReader(this, files[0].path, params, ValueCallback<String> { util->Log.e("浏览",util) });})
        dialog.show();
        })
    }


}