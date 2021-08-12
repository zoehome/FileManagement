package com.xx.Filelibrary.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.xx.Filelibrary.R;
import com.xx.Filelibrary.R2;
import com.xx.Filelibrary.ui.activity.OfficeFileActivity;
import com.xx.Filelibrary.ui.activity.PicFileActivity;

import static com.xx.Filelibrary.util.FMSaticValue.FM_FILE;
import static com.xx.Filelibrary.util.FMSaticValue.FM_IMAGE;

public class FileTypeDialog extends Dialog {

    ImageView iv_photo,iv_file;
    Activity context;
    public FileTypeDialog(@NonNull Activity context) {
        super(context, R.style.DialogTheme);
        setContentView(R.layout.dialog_file_type);
        this.context=context;
        iv_file=findViewById(R.id.iv_type_file);
        iv_photo=findViewById(R.id.iv_type_photo);
        setDialog();

    }

    public void setDialog()
    {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        iv_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivityForResult(new Intent(context, OfficeFileActivity.class), FM_FILE);
                dismiss();
            }

        });
        iv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivityForResult(new Intent(context, PicFileActivity.class), FM_IMAGE);
                dismiss();
            }

        });

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
    @Override
    public void show() {
        Window window = getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.getDecorView().setPadding(0, 0, 0, 0);
        Display display =window.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        int height = display.getHeight();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);

        wm.getDefaultDisplay().getMetrics(metrics);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
      /*  if (metrics.heightPixels < height/5*4) {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        } else {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, height/5*4);

        }*/

        super.show();
    }


}
