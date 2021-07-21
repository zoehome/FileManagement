package com.xx.Filelibrary;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class OfficeViewHolder extends ViewHolder {
    public TextView tv;

    public OfficeViewHolder(@NonNull View itemView) {
        super(itemView);
        tv=itemView.findViewById(R.id.tv_name);
    }
}
