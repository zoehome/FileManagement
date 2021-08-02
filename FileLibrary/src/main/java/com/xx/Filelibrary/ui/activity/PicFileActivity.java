package com.xx.Filelibrary.ui.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.xx.Filelibrary.ui.adapter.PicAdapter;
import com.xx.Filelibrary.ui.adapter.xxBaseRecycleViewAdapter;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public  class PicFileActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_pic_file);
        TitleBar bar = findViewById(R.id.toolbar);
        bar.setTitle("图片列表");
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
        RecyclerView rvPic = findViewById(R.id.rv_pic);
         List typeList = CollectionsKt.listOf(new String[]{".jpg", ".png"});
        FileFilter ff = (FileFilter)(new FileFilter() {
            public final boolean accept(File file) {
                return FilterFile(file, typeList);
            }
        });

        try {
            List picList = FileUtils.listFilesInDirWithFilter(PathUtils.getExternalPicturesPath(), ff, true);
            GridLayoutManager gl = new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);

            PicAdapter ad = new PicAdapter( picList,this);
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
