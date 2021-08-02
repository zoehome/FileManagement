package com.xx.Filelibrary.ui.adapter.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.xx.Filelibrary.R;
import com.xx.Filelibrary.R2;

import butterknife.BindView;

public class OfficeViewHolder extends xxBaseViewHolder {

    @BindView(R2.id.tv_name)
    public TextView tv;


    public OfficeViewHolder(View view) {
        super(view);
    }
}
