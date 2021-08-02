package com.xx.Filelibrary.ui.adapter.viewHolder;


import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xx.Filelibrary.R;
import com.xx.Filelibrary.R2;

import butterknife.BindView;

public class PicViewHolder extends xxBaseViewHolder{

    @BindView(R2.id.iv_image)
    public ImageView iv;

    public PicViewHolder(View view) {
        super(view);
    }


}