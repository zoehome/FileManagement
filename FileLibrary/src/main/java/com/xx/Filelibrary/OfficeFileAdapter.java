package com.xx.Filelibrary;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.io.File;
import java.util.List;

public  class OfficeFileAdapter extends RecyclerView.Adapter<OfficeViewHolder> {
    private  Context context;
    private  List<File> list;

    public OfficeFileAdapter(Context c, List<File> l) {
        this.context = c;
        this.list = l;
    }


    @NonNull
    @Override
    public OfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_txt, parent, false);

        return new OfficeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfficeViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




}