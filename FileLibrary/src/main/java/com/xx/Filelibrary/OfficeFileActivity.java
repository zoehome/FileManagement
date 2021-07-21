package com.xx.Filelibrary;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

class OfficeFileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_file);
        RecyclerView rvPic=findViewById(R.id.rv_pic);
        List<String> typeList=new ArrayList<>();
        typeList.add(".docx");
//        typeList.add(".xlsx");
//        typeList.add(".pdf");
//        typeList.add(".txt");

        FileFilter ff=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return FilterFile(file,typeList);
            }
        };


        try {
            List picList = FileUtils.listFilesInDirWithFilter(PathUtils.getRootPathExternalFirst(), ff, true);
            GridLayoutManager gl = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);

            OfficeFileAdapter ad = new OfficeFileAdapter(this, picList);
            rvPic.setLayoutManager(gl);
            rvPic.setAdapter(ad);
        } catch (Exception var8) {
            Log.e("文件异常", var8.toString());
        }

    }
    Boolean FilterFile(File f, List<String> fList)
    {
        for (String s : fList) {

            if (f.getName().endsWith(s))
            {
                return true;
            }
        }
        return false;
    }


}