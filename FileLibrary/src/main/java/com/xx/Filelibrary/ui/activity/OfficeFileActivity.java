package com.xx.Filelibrary.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PathUtils;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.xx.Filelibrary.R;
import com.xx.Filelibrary.ui.adapter.OfficeFileAdapter;
import com.xx.Filelibrary.ui.adapter.xxBaseRecycleViewAdapter;
import com.xx.Filelibrary.util.FMSaticValue;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class OfficeFileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_file);
        RecyclerView rvPic=findViewById(R.id.rv_pic);
        List<String> typeList=new ArrayList<>();
        typeList.add(".docx");
        typeList.add(".xlsx");
        typeList.add(".pdf");
        typeList.add(".txt");
        TitleBar bar = findViewById(R.id.toolbar);
        bar.setTitle("文件列表");
        bar.setOnTitleBarListener(new OnTitleBarListener() {
            @Override
            public void onLeftClick(View view) {
                finish();
            }

            @Override
            public void onTitleClick(View view) {

            }

            @Override
            public void onRightClick(View view) {

            }
        });
        FileFilter ff=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return FilterFile(file,typeList);
            }
        };


        try {
            List picList = FileUtils.listFilesInDirWithFilter(PathUtils.getRootPathExternalFirst(), ff, true);
            LinearLayoutManager gl = new LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false);

            OfficeFileAdapter ad = new OfficeFileAdapter( picList,this);
            rvPic.setLayoutManager(gl);
            rvPic.setAdapter(ad);
            ad.setOnItemClickListener(new xxBaseRecycleViewAdapter.OnItemClickListener<File>() {
                @Override
                public void onItemClick(int position, File bean) {
                    Intent intent=new Intent();
                   /* Bundle bundle=new Bundle();
                    bundle.putSerializable(bean.);*/
                    intent.putExtra("path",bean.getPath());
                    setResult(RESULT_OK,intent);
                    finish();

                }
            });
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