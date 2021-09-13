package com.xx.Filelibrary.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xx.Filelibrary.callback.FileCallBack;
import com.xx.Filelibrary.ui.activity.OfficeFileActivity;
import com.xx.Filelibrary.ui.activity.PicFileActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.xx.Filelibrary.util.FMSaticValue.FM_FILE;
import static com.xx.Filelibrary.util.FMSaticValue.FM_IMAGE;

public class HolderFragment extends Fragment {


    FileCallBack mCallBack;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void startXxPhoto(FileCallBack callBack)
    {
        this.mCallBack=callBack;
        startActivityForResult(new Intent(getContext(), PicFileActivity.class), FM_IMAGE);

    }

    public void startXxFile(FileCallBack callBack)
    {
        this.mCallBack=callBack;
        startActivityForResult(new Intent(getContext(), OfficeFileActivity.class), FM_FILE);

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode== RESULT_OK)
        {
            if ( data.getStringExtra("path")!=null)
            {
                List<File> fileList=new ArrayList<>();
                fileList.add(new File( data.getStringExtra("path")));
                mCallBack.reFile(fileList);

            }

        }
    }
}
