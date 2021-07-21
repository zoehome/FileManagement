package com.xx.Filelibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.PathUtils
import java.io.File
import java.io.FileFilter

class PicFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_file)

        val rvPic:RecyclerView=findViewById(R.id.rv_pic);

        val typeList:List<String> = listOf(".jpg",".png")
        val ff:FileFilter= FileFilter { file -> FilterFile(file,typeList) }


        try {
            var  picList =
                FileUtils.listFilesInDirWithFilter(PathUtils.getRootPathExternalFirst(), ff, true)
            val gl:GridLayoutManager= GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);

            val ad:PicAdapter= PicAdapter(this, picList);

            rvPic.layoutManager=gl;
            rvPic.adapter=ad;
        } catch (e: Exception) {
            Log.e("文件异常", e.toString())
        }

    }

    fun FilterFile(f: File, fList: List<String>):Boolean
    {
        for (s in fList) {

            if (f.name.endsWith(s))
            {
                return true
            }
        }
        return false
    }

}