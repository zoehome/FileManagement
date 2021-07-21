package com.xx.filemanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.PathUtils
import java.io.File
import java.io.FileFilter

class OfficeFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_file)

        val rvPic:RecyclerView=findViewById(R.id.rv_pic);

        val typeList:List<String> = listOf(".docx",".xlsx",".pdf",".txt")
        val ff:FileFilter= FileFilter { file -> FilterFile(file,typeList) }


        try {
            var  picList =
                FileUtils.listFilesInDirWithFilter(PathUtils.getRootPathExternalFirst(), ff, true)
            val gl:LinearLayoutManager= LinearLayoutManager(this, GridLayoutManager.VERTICAL, false);

            val ad:OfficeFileAdapter= OfficeFileAdapter(this, picList);

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